package com.wh.base.utils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.wh.base.bean.privilege.User;

public class WebUtil {
	/**
	 * 获取登陆用户
	 * @param request
	 * @return
	 */
	public static User getUser(){
		return (User) ActionContext.getContext().getSession().get("user");
	}
	public static String getContextPath() {
		return ServletActionContext.getRequest().getContextPath();
	}
}
