package com.bingoogol.spring.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingoogol.spring.dto.AjaxObj;
import com.bingoogol.spring.dto.UserRegistDto;
import com.bingoogol.spring.exception.IllegalClientException;
import com.bingoogol.spring.service.ChannelService;
import com.bingoogol.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	@Resource
	private ChannelService channelService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("channels", channelService.selectChannel(-1));
		return "front/user/register";
	}

	// TODO
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String register(@Valid UserRegistDto userRegistDto, BindingResult bindingResult, HttpSession session) {
		AjaxObj ajaxObj = new AjaxObj();
		if (bindingResult.hasErrors()) {
			// 此时没有通过浏览器表单正常提交（比如通过postman提交）或者浏览器js被禁用了
			throw new IllegalClientException("请通过正确的方式提交信息");
		}
		if (!userRegistDto.getVcode().equalsIgnoreCase((String) session.getAttribute("vcode"))) {
			ajaxObj.setSuccess(false);
			ajaxObj.setMsg("验证码输入错误");
		} else {
			String id = userService.register(userRegistDto);
			if (id != null) {
				ajaxObj.setSuccess(true);
				ajaxObj.setObj(id);
			} else {
				ajaxObj.setSuccess(false);
				ajaxObj.setMsg("注册失败");
			}
			session.removeAttribute("vcode");
		}
		return new JSONObject(ajaxObj).toString();
	}

	@RequestMapping(value = "/vusername", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String vusername(String username) {
		return userService.isUsernameAvailable(username) == true ? "true" : "false";
	}

	@RequestMapping(value = "/vemail", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String vemail(String email) {
		return userService.isEmailAvailable(email) == true ? "true" : "false";
	}

	// TODO
	@RequestMapping(value = "/activeui", method = RequestMethod.GET)
	public String activeui(String id,int status, Model model) {
		if(status == 3) {
			model.addAttribute("msg", "对不起，您的邮箱未激活，请先到邮箱激活");
		} else {
			model.addAttribute("msg", "激活邮件已发送到您的邮箱，请到邮箱激活。 没有收到邮件？");
		}
		model.addAttribute("id", id);
		return "front/user/active";
	}

	// TODO
	@RequestMapping(value = "/active/{activecode}/{id}", method = RequestMethod.GET)
	public String active(@PathVariable String activecode, @PathVariable String id, Model model) {
		if (userService.active(id, activecode)) {
			return "/front/index";
		}
		model.addAttribute("msg", "邮箱激活失败");
		model.addAttribute("id", id);
		return "front/user/active";
	}
	// TODO
	@RequestMapping(value = "/resendemail/{id}", method = RequestMethod.GET)
	public String resendemail(@PathVariable String id, Model model) {
		model.addAttribute("id", id);
		if (userService.resendemail(id)) {
			model.addAttribute("msg", "激活邮件已发送到您的邮箱，请到邮箱激活。 没有收到邮件？");
		} else {
			model.addAttribute("msg", "激活邮件发送失败");
		}
		return "front/user/active";
	}

}
