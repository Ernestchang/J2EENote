package com.bingoogol.spring.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingoogol.spring.dto.AddAlgorithmDto;
import com.bingoogol.spring.dto.AjaxObj;
import com.bingoogol.spring.exception.IllegalClientException;
import com.bingoogol.spring.service.AlgorithmService;
import com.bingoogol.spring.service.AttachmentService;
import com.bingoogol.spring.service.ChannelService;
import com.bingoogol.spring.service.UserService;
import com.bingoogol.spring.util.QiniuUtil;

/**
 * 七牛云存储控制器
 * 
 * @author bingoogol@sina.com
 */
@Controller
@RequestMapping("/algorithm")
public class AlgorithmController {
	@Resource
	private ChannelService channelService;
	@Resource
	private AlgorithmService algorithmService;
	@Resource
	private AttachmentService attachmentService;
	@Resource
	private UserService userService;

	// TODO 临时的
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list", algorithmService.list());
		return "front/algorithm/list";
	}
	
	@RequestMapping(value = "/auth/publish", method = RequestMethod.GET)
	public String publish(Model model) {
		model.addAttribute("channels", channelService.selectChannel(-1));
		return "front/algorithm/publish";
	}

	@RequestMapping(value = "/auth/publish", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String publish(@Valid AddAlgorithmDto addAlgorithmDto, BindingResult bindingResult, HttpSession session) {
		AjaxObj ajaxObj = new AjaxObj();
		if (bindingResult.hasErrors()) {
			for(ObjectError e : bindingResult.getAllErrors()) {
				System.out.println(e.getDefaultMessage());
			}
			// 此时没有通过浏览器表单正常提交（比如通过postman提交）或者浏览器js被禁用了
			throw new IllegalClientException("请通过正确的方式提交信息");
		}
		if (!addAlgorithmDto.getVcode().equalsIgnoreCase((String) session.getAttribute("vcode"))) {
			ajaxObj.setSuccess(false);
			ajaxObj.setMsg("验证码输入错误");
		} else {
			@SuppressWarnings("unchecked")
			Map<String,Object> loginUser = (Map<String, Object>) session.getAttribute("loginUser");
			addAlgorithmDto.setUid((String) loginUser.get("id"));
			if (algorithmService.addAlgorithm(addAlgorithmDto)) {
				ajaxObj.setSuccess(true);
			} else {
				ajaxObj.setSuccess(false);
				ajaxObj.setMsg("算法发布失败");
			}
			session.removeAttribute("vcode");
		}
		return new JSONObject(ajaxObj).toString();
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable String id, Model model) {
		Map<String,Object> algorithm = algorithmService.getAlgorithmById(id);
		String thesis = (String) algorithm.get("thesis");
		String hash = attachmentService.getHashByid(thesis);
		model.addAttribute("algorithm", algorithm);
		model.addAttribute("docUrl", QiniuUtil.getDocUrl(hash));
		return "front/algorithm/detail";
	}
	
	@RequestMapping(value = "/auth/buy/{id}", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String buy(@PathVariable String id, HttpSession session) {
		System.out.println("buy");
		AjaxObj ajaxObj = new AjaxObj();
		@SuppressWarnings("unchecked")
		Map<String,Object> loginUser = (Map<String, Object>) session.getAttribute("loginUser");
		String buyerid = (String)loginUser.get("id");
		int gold = userService.getGold(buyerid);
		Map<String,Object> algorithm = algorithmService.getAlgorithmById(id);
		int price = (int)algorithm.get("price");
		if(gold < price) {
			ajaxObj.setSuccess(false);
			ajaxObj.setMsg("对不起，您的金币不足");
		} else {
			String sellerid = (String) algorithm.get("uid");
			if(userService.buy(buyerid,sellerid,price)) {
				ajaxObj.setSuccess(true);
			}else {
				ajaxObj.setSuccess(false);
				ajaxObj.setMsg("对不起，购买失败，请重新购买");
			}
		}
		return new JSONObject(ajaxObj).toString();
	}

}