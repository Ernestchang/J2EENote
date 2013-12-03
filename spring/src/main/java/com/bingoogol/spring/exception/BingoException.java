package com.bingoogol.spring.exception;

public class BingoException extends RuntimeException {
	private static final long serialVersionUID = 192465273410589223L;

	public BingoException() {
		super();
	}

	public BingoException(String message, Throwable cause) {
		super(message, cause);
	}

	public BingoException(String message) {
		super(message);
	}

	public BingoException(Throwable cause) {
		super(cause);
	}
}
