package com.wh.base.web.action.privilege;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.base.utils.SiteUrl;
@Controller
public class TokenAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		ActionContext.getContext().put("message", "请不要重复提交表单");
		ActionContext.getContext().put("urladdress", SiteUrl.readUrl("user.list"));
		return "message";
	}

}
