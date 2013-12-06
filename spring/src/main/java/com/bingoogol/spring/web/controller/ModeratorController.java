package com.bingoogol.spring.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bingoogol.spring.service.ChannelService;
import com.bingoogol.spring.service.UserService;

@Controller
@RequestMapping("/moderator")
public class ModeratorController {

	@Resource
	private UserService userService;
	@Resource
	private ChannelService channelService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "moderator/index";
	}
}
