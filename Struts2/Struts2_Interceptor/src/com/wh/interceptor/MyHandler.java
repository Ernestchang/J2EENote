package com.wh.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

	private Object object;
	private MyInterceptor interceptor = new MyInterceptor();
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		interceptor.before();
		result = method.invoke(object, args);
		interceptor.after();
		return result;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}

}
