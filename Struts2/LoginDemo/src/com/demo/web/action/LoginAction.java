package com.demo.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 4491669814094321252L;
	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		System.out.println("username:" + username + " password:" + password);
		if (null != username && null != password && "hello".equals(username) && "world".equals(password)) {
			return SUCCESS;
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
