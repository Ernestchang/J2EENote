package com.wh.action.json;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.wh.bean.Person;

public class GetJsonAction extends ActionSupport {
	private static final long serialVersionUID = 2439136801668425046L;
	private String name;
	private int id;
	private int age;
	private String address;
	private Date date;
	private Person person = new Person();

	@Override
	public String execute() throws Exception {
		// zhangsan
		Person person1 = new Person();
		person1.setId(1);
		person1.setName("zhangsan");
		person1.setAge(20);
		person1.setAddress("shanghai");
		person1.setDate(new Date());
		// lisi
		Person person2 = new Person();
		person2.setId(2);
		person2.setName("lisi");
		person2.setAge(30);
		person2.setAddress("chongqing");
		person2.setDate(new Date());
		if ("zhangsan".equals(name)) {
			this.id = person1.getId();
			this.name = person1.getName();
			this.age = person1.getAge();
			this.address = person1.getAddress();
			this.date = person1.getDate();
		} else {
			this.id = person2.getId();
			this.name = person2.getName();
			this.age = person2.getAge();
			this.address = person2.getAddress();
			this.date = person2.getDate();
		}

		return SUCCESS;
	}

	/**
	 * @return the name
	 */
	// @JSON(name="myname")
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	// @JSON(serialize=false) //是否返回给客户端
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the age
	 */
	@JSON(deserialize=true)
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the date
	 */
	// @JSON(format="yyyy-MM-dd",name="mydate")
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

}
