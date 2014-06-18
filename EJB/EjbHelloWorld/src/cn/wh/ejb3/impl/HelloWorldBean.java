/*
ejb3.0 的remote和local接口
1.@Remote 注释指明实现的接口是远程接口，@Local注释指明实现的接口是本地接口。
当@Local 和@Remote 注释都不存在时，会话 Bean 实现的接口默认为 Local接口。
如果在本地用 EJB（确保客户端与 EJB 容器运行在同一个 JVM），采用 Local 接口
访问 EJB 优于 Remote 接口，因为 Remote接口访问 EJB 需要经过远程方法
调用(RPCs)环节，而 Local 接口访问 EJB 直接从 JVM 中返回 EJB 的引用。
2. StatelessSessionBean不负责记录使用者状态，StatelessSessionBean一旦实
例化就被加进会话池中，各个用户都可以共用。即使用户已经消亡，StatelessSessionBean的
生命期也不一定结束，它可能依然存在于会话池中，供其他用户调用。如果它有自己的属性（变量）
，那么这些变量就会受到所有调用它的用户的影响。所以有可能新NEW的那个对象,用的还是上个对象的东西
3.statefulsessionbean 必须实现 Serializable 接口，这样EJB容器才能在她们不再使用时序
列化存储她们的状态信息.@SuppressWarnings("serial") 注释屏蔽缺少 serialVersionUID 定义的警告。
 */
package cn.wh.ejb3.impl;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import cn.wh.ejb3.HelloWorld;
import cn.wh.ejb3.HelloWorldLocal;
import cn.wh.ejb3.Other;
//@Stateful  //指明该类为有状态的会话bean
@Stateless
@Remote(HelloWorld.class)
@Local(HelloWorldLocal.class)
public class HelloWorldBean implements HelloWorld {
	@EJB(beanName="OtherBean") Other other;
	public String sayHello(String name) {
//		try {
//			InitialContext ctx = new InitialContext();
//			Other other = (Other) ctx.lookup("OtherBean/local");
//			return name + "说：你好," + other.sayMe();
//	  	} catch (NamingException e) {
//			e.printStackTrace();
//		}
//		return null;
		return name + "说：你好," + other.sayMe();
	}

}
