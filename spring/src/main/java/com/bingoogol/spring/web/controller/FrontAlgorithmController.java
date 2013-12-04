package com.bingoogol.spring.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingoogol.spring.service.ChannelService;
import com.bingoogol.spring.util.QiniuUtil;

/**
 * 七牛云存储控制器
 * 
 * @author bingoogol@sina.com
 */
@Controller
@RequestMapping("/front/algorithm")
public class FrontAlgorithmController {
	@Resource
	private ChannelService channelService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable int id, Model model) {
		
		return "front/algorithm/detail";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("channels", channelService.selectChannel(-1));
		return "front/algorithm/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String add() {
		
		return "";
	}

	@RequestMapping(value = "/getPublicUpToken", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String getPublicUpToken() {
		return QiniuUtil.getPublicUpToken();
	}
	
	@RequestMapping(value = "/getPrivateUpToken", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String getPrivateUpToken() {
		return QiniuUtil.getPrivateUpToken();
	}

}