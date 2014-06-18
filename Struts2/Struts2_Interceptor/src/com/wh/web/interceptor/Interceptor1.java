package com.wh.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Interceptor1 implements Interceptor {
	private static final long serialVersionUID = -5860028479004215814L;
	private String test;
	@Override
	public void destroy() {
		System.out.println("destory");
	}

	@Override
	public void init() {
		System.out.println("inint invoked1");
		System.out.println("test:" + this.test);
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("interceptor before1");
		String resutl = invocation.invoke();
		System.out.println("interceptor after1");
		return resutl;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		System.out.println("setTest invoked1");
		this.test = test;
	}

}
