package com.wh.base.web.action.privilege;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class LogoutAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return LOGIN;
	}
}
