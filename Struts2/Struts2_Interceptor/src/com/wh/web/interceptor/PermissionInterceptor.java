package com.wh.web.interceptor;

import java.lang.reflect.Method;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wh.permission.Permission;

public class PermissionInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 5643988504434946324L;
	/*
	 * 定义拦截器是可以直接继承AbstractInterceptor抽象类（该类实现了Interceptor接口，并且对init
	 * 和desroy方法进行了空实现），然后实现其抽象方法intercept即可
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("interceptor before2");
		String methodName = invocation.getProxy().getMethod();
		System.out.println("方法名:" + methodName);
		System.out.println("类名:" + invocation.getAction());
		Method method = invocation.getAction().getClass().getMethod(methodName);
		Permission permission = method.getAnnotation(Permission.class);
		System.out.println("module=" + permission.module() + "--------privilege=" + permission.privilege());
		
		Map<String,Object> map = invocation.getInvocationContext().getSession();
		if(null == map.get("user")) {
			return Action.LOGIN;
		}
		
		String result = invocation.invoke();
		System.out.println("interceptor after2");
		return result;
	}

}
