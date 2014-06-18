package com.wh.entity;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@NotEmpty
	private String name;
	@Size(max = 20, min = 5)
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
