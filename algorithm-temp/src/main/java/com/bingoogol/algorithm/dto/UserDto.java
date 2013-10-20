package com.bingoogol.algorithm.dto;

import com.bingoogol.algorithm.model.User;


public class UserDto {
	private String username;
	private String password;
	private String email;
	private Integer cid;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public User getUser() {
		User user = new User();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
}
