package cn.wh.bean;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = 7711382370954266412L;
	private String name;
	private String orderid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
}
