package com.wh.bean;

import java.util.List;

public class People {
	private int id;
	private String name;
	private Address address;
	private List<People> friends;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the friends
	 */
	public List<People> getFriends() {
		return friends;
	}
	/**
	 * @param friends the friends to set
	 */
	public void setFriends(List<People> friends) {
		this.friends = friends;
	}
}
