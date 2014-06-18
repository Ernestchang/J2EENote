package com.wh.exception;

public class PasswordException extends Exception {
	private static final long serialVersionUID = -6890066040455029205L;
	private String message;
	public PasswordException(String message) {
		super(message);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
