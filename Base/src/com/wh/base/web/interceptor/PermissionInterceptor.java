package com.wh.base.web.interceptor;

import java.lang.reflect.Method;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wh.base.bean.privilege.Permission;
import com.wh.base.bean.privilege.PrivilegeGroup;
import com.wh.base.bean.privilege.SystemPrivilege;
import com.wh.base.bean.privilege.SystemPrivilegePK;
import com.wh.base.bean.privilege.User;
import com.wh.base.utils.SiteUrl;
import com.wh.base.utils.WebUtil;

public class PermissionInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -4431977378844348269L;
	/*
	 * 定义拦截器是可以直接继承AbstractInterceptor抽象类（该类实现了Interceptor接口，并且对init
	 * 和desroy方法进行了空实现），然后实现其抽象方法intercept即可
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		if(!isLogin()) {
			return "login";
		}
		String methodName = invocation.getProxy().getMethod();
		Method method = invocation.getAction().getClass().getMethod(methodName);
		Permission permission = method.getAnnotation(Permission.class);
		if(null != permission && !isPermission(permission)) {
			ActionContext.getContext().put("message", "您没有执行该操作的权限");
			ActionContext.getContext().put("urladdress", SiteUrl.readUrl("message.list"));
			return "message";
		}
		return invocation.invoke();
	}
	/**
	 * 判断用户是否登录
	 * @return
	 */
	private boolean isLogin() {
		String uri = ServletActionContext.getRequest().getRequestURI();
		//如果用户未登录，重定向到用户登陆界面
		if(null == WebUtil.getUser() && !uri.contains("login") && !uri.contains("code")){
			ActionContext.getContext().put("message", "请登录后再访问");
			return false;
		}
		return true;
	}
	/**
	 * 判断用户是否有权限操作
	 * @param permission
	 * @return
	 */
	private boolean isPermission(Permission permission) {
		User user = WebUtil.getUser();
		System.out.println("module:" + permission.module() + "       privilege:" + permission.privilege());
		SystemPrivilegePK systemPrivilegePK = new SystemPrivilegePK(permission.module(), permission.privilege());
		SystemPrivilege privilege = new SystemPrivilege(systemPrivilegePK);
		for(PrivilegeGroup group : user.getGroups()){
			if(group.getPrivileges().contains(privilege)){
				return true;
			}
		}
		return false;
	}

}
