package com.bingoogol.spring.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingoogol.spring.dto.AjaxObj;
import com.bingoogol.spring.service.ChannelService;

@Controller
@RequestMapping("/channel")
public class ChannelController {
	@Resource
	private ChannelService channelService;

	@RequestMapping(value = "/admin/channels", method = RequestMethod.GET)
	public String channels(int cid, int level, Model model) {
		model.addAttribute("list", channelService.listChilds(cid));
		model.addAttribute("cid", cid);
		switch (level) {
		case 2:
			return "admin/channel/channel2";
		case 3:
			return "admin/channel/channel3";
		default:
			return "admin/channel/channel1";
		}
	}

	@RequestMapping(value = "/admin/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String add(String name, int cid, int level, HttpSession session) {
		AjaxObj ajaxObj = new AjaxObj();
		@SuppressWarnings("unchecked")
		Map<String, Object> loginUser = (Map<String, Object>) session.getAttribute("loginUser");
		if (channelService.addChannel(name, cid, level, (String) loginUser.get("id"))) {
			ajaxObj.setSuccess(true);
		} else {
			ajaxObj.setSuccess(false);
			ajaxObj.setMsg("添加学科失败");
		}
		return new JSONObject(ajaxObj).toString();
	}

	@RequestMapping(value = "/admin/vname", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String vname(String name) {
		return channelService.isNameAvailable(name) == true ? "true" : "false";
	}
	
	@RequestMapping(value = "/select/{cid}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String selectChannel(@PathVariable int cid) {
		AjaxObj ajaxObj = new AjaxObj();
		ajaxObj.setObj(channelService.selectChannel(cid));
		ajaxObj.setSuccess(true);
		return new JSONObject(ajaxObj).toString();
	}

}
