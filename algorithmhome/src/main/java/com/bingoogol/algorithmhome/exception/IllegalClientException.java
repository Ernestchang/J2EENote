package com.bingoogol.algorithmhome.exception;

public class IllegalClientException extends RuntimeException {
	private static final long serialVersionUID = 192465273410589223L;

	public IllegalClientException() {
		super();
	}

	public IllegalClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalClientException(String message) {
		super(message);
	}

	public IllegalClientException(Throwable cause) {
		super(cause);
	}
}
