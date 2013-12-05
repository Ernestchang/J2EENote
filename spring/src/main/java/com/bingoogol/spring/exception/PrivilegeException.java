package com.bingoogol.spring.exception;

public class PrivilegeException extends RuntimeException {
	private static final long serialVersionUID = 192465273410589223L;

	public PrivilegeException() {
		super();
	}

	public PrivilegeException(String message, Throwable cause) {
		super(message, cause);
	}

	public PrivilegeException(String message) {
		super(message);
	}

	public PrivilegeException(Throwable cause) {
		super(cause);
	}
}
