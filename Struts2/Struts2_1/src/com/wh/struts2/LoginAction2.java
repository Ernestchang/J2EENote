package com.wh.struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.wh.bean.Person;

public class LoginAction2 extends ActionSupport implements ModelDriven<Person>,Preparable {
	private static final long serialVersionUID = 8394129828602471760L;
	/*
	 * 模型驱动，自己需要创建一个对象，但是对象里面的属性不需要我们自己赋值
	 * 属性驱动特点：灵活，准确
	 * 模型驱动特点：不灵活，因为很多时候页面所提交过来的参数与模型中的属性并不一致，这是很常见的情况
	 * 			模型驱动更加符合面向对象的编程风格，使得我们获得的是一个完整的对象而不是一个个离散的值
	 * 小结：推荐使用属性驱动编写Action
	 */
	
	/*
	 * Perparable接口的作用是让Action完成一些初始化工作，这些工作是放在Preparable接口
	 * 的prapare方法中完成的，该方法会在execute方法执行之前被调用
	 */
	private Person person = new Person();
	@Override
	public Person getModel() {
		System.out.println("getModel invoked");
		return person;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("execute invoked");
		System.out.println(person.getUsername());
		return SUCCESS;
	}
	@Override
	public void prepare() throws Exception {
		System.out.println("prepare invoked");
		
	}

}
