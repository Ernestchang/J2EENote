/**
 * mesType=1������¼�ɹ�
 * mesType=2������¼ʧ��
 * mesType=3��������ͨ����Ϣ��
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
