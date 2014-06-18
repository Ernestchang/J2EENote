package test;

import com.wh.interceptor.MyProxy;
import com.wh.target.ITarget;
import com.wh.target.impl.TargetImpl;

public class Client {
	public static void main(String[] args) {
		ITarget target = new TargetImpl();
		MyProxy myProxy = new MyProxy();
		//获取代理对象
		ITarget proxy = (ITarget) myProxy.getProxy(target);
		proxy.doSomething();
	}
}
