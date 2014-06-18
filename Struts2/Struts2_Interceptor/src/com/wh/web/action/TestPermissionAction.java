package com.wh.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wh.permission.Permission;
public class TestPermissionAction extends ActionSupport {
	private static final long serialVersionUID = -5292716712058393693L;
	@Permission(module="wanghao",privilege="bingo")
	public String execute() throws Exception {
		return SUCCESS;
	}
	@Permission(module="wanghao",privilege="bingo")
	public String myExecute() throws Exception {
		return SUCCESS;
	}
}
