package com.wh.target.impl;

import com.wh.target.ITarget;

//java里面动态代理要求必须实现接口
public class TargetImpl implements ITarget {

	@Override
	public void doSomething() {
		System.out.println("do something");
	}

}
