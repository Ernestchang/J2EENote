package com.wh.interceptor;

import java.lang.reflect.Proxy;

import com.wh.target.impl.TargetImpl;

public class MyProxy {

	public Object getProxy(Object object) {
		MyHandler myHandler = new MyHandler();
		myHandler.setObject(object);
		return Proxy.newProxyInstance(TargetImpl.class.getClassLoader(), object.getClass().getInterfaces(), myHandler);
	}
}
