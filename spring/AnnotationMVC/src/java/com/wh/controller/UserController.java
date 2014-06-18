package com.wh.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wh.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String addForm() {
		return "add_user";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addUser(@Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			//返回到错误页面
		}
		//重定向
		return "redirect:/add_success";
	}
	
}
