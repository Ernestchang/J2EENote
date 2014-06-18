/**
 * mesType=1表明登录成功
 * mesType=2表明登录失败
 * mesType=3表明是普通的消息包
 */
package com.common;

import java.io.Serializable;

public class Message implements Serializable {
	private String mesType;
	private String sender;
	private String getter;
	private String info;
	private String sendTime;
	public String getMesType() {
		return mesType;
	}

	public void setMesType(String mesType) {
		this.mesType = mesType;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getGetter() {
		return getter;
	}

	public void setGetter(String getter) {
		this.getter = getter;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
}
