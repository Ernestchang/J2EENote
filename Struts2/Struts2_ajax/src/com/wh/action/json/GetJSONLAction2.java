package com.wh.action.json;
import com.opensymphony.xwork2.ActionSupport;


public class GetJSONLAction2 extends ActionSupport {
	private static final long serialVersionUID = -9024324330171707088L;
	private String name;
	private int age;
	private String address;
	private int id;
	@Override
	public String execute() throws Exception {
		System.out.println("execute invoked");
		this.id = 1;
		this.age = 30;
		this.address = "beijing";
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
