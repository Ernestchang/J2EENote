package com.wh.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wh.struts2.LoginAction;

public class LoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 8005508626371723256L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		if(LoginAction.class == invocation.getAction().getClass()) {
			return invocation.invoke();
		}
		Map<String,Object> map = invocation.getInvocationContext().getSession();
		if(null == map.get("userInfo")) {
			return Action.LOGIN;
		}
		return invocation.invoke();
	}

}
