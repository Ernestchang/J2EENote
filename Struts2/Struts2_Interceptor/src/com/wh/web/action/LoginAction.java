package com.wh.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.bean.User;
import com.wh.service.UserService;
import com.wh.service.impl.UserServiceBean;
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -5292716712058393693L;
	private String username;
	private String password;
	private UserService userService = new UserServiceBean();
	/*
	 * 属性驱动（用户提交表单后属性被自动赋值）
	 */
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
	
	public String execute() throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if(userService.validate(user)) {
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		return INPUT;
	}
}
