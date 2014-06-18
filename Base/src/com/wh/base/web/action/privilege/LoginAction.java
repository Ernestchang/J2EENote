package com.wh.base.web.action.privilege;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.base.service.user.UserService;

@Controller
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	private String username;
	private String password;
	@Override
	public String execute() throws Exception {
		if(username !=null && !"".equals(username.trim()) && password !=null && !"".equals(password.trim())){
			if(userService.checkUser(username.trim(), password.trim())){
				ActionContext.getContext().getSession().put("user", userService.find(username));
				return SUCCESS;
			}
			ActionContext.getContext().put("message", "用户名或密码错误");
		}
		return INPUT;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
