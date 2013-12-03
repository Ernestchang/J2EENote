package com.bingoogol.algorithm.web.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bingoogol.algorithm.dto.Json;
import com.bingoogol.algorithm.dto.UserDto;
import com.bingoogol.algorithm.model.Channel;
import com.bingoogol.algorithm.model.User;
import com.bingoogol.algorithm.service.IChannelService;
import com.bingoogol.algorithm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IChannelService channelService;

	@RequestMapping(value="/front/register",method=RequestMethod.GET)
	public String register(Model model) {
		return "front/register";
	}
	@RequestMapping(value="/front/register",method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public @ResponseBody String register(UserDto userDto, HttpSession session) {
		Json json = new Json();
		Channel channel = channelService.getChannel(userDto.getCid());
		User user = userDto.getUser();
		user.setChannel(channel);
		user.setScore(0);
		user.setDateCreated(new Date());
		user.setDateModified(new Date());
		userService.addUser(user);
		session.setAttribute("loginUser", user);
		json.setSuccess(true);
		return JSON.toJSONString(json);
	}
	
	@RequestMapping(value="/front/available",method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public @ResponseBody String available(String username) {
		User user = userService.getByUsername(username);
		Json json = new Json();
		if(user == null ) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
		}
		return JSON.toJSONString(json);
	}
}
