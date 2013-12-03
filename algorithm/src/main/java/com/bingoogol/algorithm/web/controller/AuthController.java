package com.bingoogol.algorithm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bingoogol.algorithm.dto.Json;
import com.bingoogol.algorithm.model.User;
import com.bingoogol.algorithm.service.IUserService;
import com.bingoogol.algorithm.util.MD5Util;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/front/login",method=RequestMethod.GET)
	public String frontLogin() {
		return "front/login";
	}
	
	@RequestMapping(value="/front/login",method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public @ResponseBody String frontLogin(String username,String password,HttpSession session) {
		User user = userService.getByUsername(username);
		Json json = new Json();
		if(user != null) {
			if(user.getPassword().equals(MD5Util.md5(username, password))) {
				json.setSuccess(true);
				json.setMsg("登陆成功");
				session.setAttribute("loginUser", user);
			} else {
				json.setSuccess(false);
				json.setMsg("用户名或密码错误");
			}
		} else {
			json.setSuccess(false);
			json.setMsg("该用户不存在");
		}
		return JSON.toJSONString(json);
	}
	
	@RequestMapping("/front/logout")
	public String frontLogout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "redirect:/auth/front/login";
	}
	
	

}
