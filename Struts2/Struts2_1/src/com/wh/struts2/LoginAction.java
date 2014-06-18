package com.wh.struts2;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.bean.User;
import com.wh.service.LoginService;
import com.wh.service.impl.LoginServiceImpl;
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -5292716712058393693L;
	private String username;
	private String password;
	private int age;
	private Date date;
	private LoginService loginService = new LoginServiceImpl();
	/*
	 * 属性驱动（用户提交表单后属性被自动赋值）
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String execute() throws Exception {
//		if(!"hello".equals(username)) {
//			throw new UsernameException("username invalid");
//		}
//		if(!"world".equals(password)) {
//			throw new PasswordException("password invalid");
//		}
		return SUCCESS;
	}
	/*
	 * 1.Action中自定义方法的输入校验，对于通过action的method属性所指定的自定方法，其对应的
	 * 自定义输入校验方法名为validateMyExecute（假定自定义的方法名为myExecute)。底层是
	 * 通过反射来调用的
	 */
	/*
	 * 2.当在Action中指定了自定义的execute方法时，首先会执行自定义的execute方法所对应的输入校验
	 * 方法，然后再去执行validate方法，执行完毕后如果出现了任何错误都不会再去执行自定义的execute方
	 * 法，流程转向了input这个名字所对应的页面上
	 */
	public void validateMyExecute() {
//		this.addActionError("ttt");
//		System.out.println("validateMyExecute");
	}
	@Override
	public void validate() {
		//主要用于没有业务逻辑的验证
//		this.addActionError("t");
//		System.out.println("validate invoked");
	}
	/*
	 * Struts2框架校验执行的先后顺序
	 * 1.首先执行校验框架（xml文件）
	 * 2.执行自定义方法的校验方法
	 * 3.执行validate方法
	 */
}
