package com.wh.base.web.action.privilege;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.base.service.user.UserService;
import com.wh.base.utils.SiteUrl;
@Controller
public class DeleteUserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String username;
	@Resource
	private UserService userService;
	@Override
	public String execute() throws Exception {
		userService.delete(username);
		ActionContext.getContext().put("message", "删除成功");
		ActionContext.getContext().put("urladdress", SiteUrl.readUrl("user.list"));
		return "message";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
