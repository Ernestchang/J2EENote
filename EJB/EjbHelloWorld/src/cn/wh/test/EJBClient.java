package cn.wh.test;

import javax.naming.InitialContext;

import cn.wh.ejb3.HelloWorld;

public class EJBClient {

//	public static void main(String[] args) {
//		Properties props = new Properties();
//		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
//		props.setProperty("java.naming.provider.url", "localhost:1099");
//		try {
//			InitialContext ctx = new InitialContext(props);
//			HelloWorld helloWorld = (HelloWorld) ctx.lookup("HelloWorldBean/remote");
//			System.out.println(helloWorld.getClass().getName());
//			System.out.println(helloWorld.sayHello("王浩"));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	public static void main(String[] args) {
		try {
			InitialContext ctx = new InitialContext();
			HelloWorld helloWorld = (HelloWorld) ctx.lookup("HelloWorldBean/remote");
			System.out.println(helloWorld.getClass().getName());
			System.out.println(helloWorld.sayHello("远程人"));
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
	}

}
