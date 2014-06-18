package com.wh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wh.service.LoginService;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 6835398114031312071L;
	private String username;
	private String password;
	private LoginService loginService;

	public String execute() throws Exception {
		if (loginService.isLogin(username, password)) {
			return SUCCESS;
		} else {
			return INPUT;
		}
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

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
