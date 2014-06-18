/**
 * 演示对象序列化
 */
package com.common;

import java.io.ObjectInputStream;
import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
