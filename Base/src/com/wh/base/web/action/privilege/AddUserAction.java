package com.wh.base.web.action.privilege;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.base.bean.privilege.User;
import com.wh.base.service.user.UserService;
import com.wh.base.utils.SiteUrl;
@Controller
public class AddUserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	private String username;
	private String password;
	private String realname;
	@Override
	public String execute() throws Exception {
		String message = "添加成功";
		if(userService.exsit(username)) {
			message = "该用户名已被注册";
		} else {
			User user = new User();
			user.setPassword(password);
			user.setRealname(realname);
			user.setUsername(username);
			userService.save(user);
		}
		ActionContext.getContext().put("message", message);
		ActionContext.getContext().put("urladdress", SiteUrl.readUrl("user.list"));
		return "message";
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
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
}
