package com.wh.bean;

public class Person {
	private Integer id;
	private String name;
	public Person() {}
	public Person(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// create table person(
	// id int primary key auto_increment,
	// name varchar(5) not null
	// );
}
