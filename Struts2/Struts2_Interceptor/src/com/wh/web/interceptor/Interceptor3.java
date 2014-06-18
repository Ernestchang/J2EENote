package com.wh.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.wh.web.listener.TheListener;

public class Interceptor3 extends MethodFilterInterceptor {
	private static final long serialVersionUID = 2274774397079821755L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		invocation.addPreResultListener(new TheListener());
		System.out.println("interceptor before3");
		String result = invocation.invoke();
		//在这中间执行监听器的beforeResult方法
		System.out.println("interceptor after3");
		return result;
	}

}
