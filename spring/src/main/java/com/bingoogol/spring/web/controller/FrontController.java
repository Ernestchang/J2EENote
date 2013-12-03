package com.bingoogol.spring.web.controller;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingoogol.spring.dto.AjaxObj;
import com.bingoogol.spring.service.ChannelService;

@Controller
@RequestMapping("/front")
public class FrontController {
	@Resource
	private ChannelService channelService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "front/index";
	}

	@RequestMapping(value = "/selectChannel/{cid}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String selectChannel(@PathVariable int cid) {
		AjaxObj ajaxObj = new AjaxObj();
		ajaxObj.setObj(channelService.selectChannel(cid));
		ajaxObj.setSuccess(true);
		return new JSONObject(ajaxObj).toString();
	}

}
