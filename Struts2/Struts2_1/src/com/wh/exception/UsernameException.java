package com.wh.exception;

public class UsernameException extends Exception {
	private static final long serialVersionUID = -3854673119412521972L;
	private String massage;
	public UsernameException(String message) {
		super(message);
		this.massage = message;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
}
