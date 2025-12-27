package com.rent.bff.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 27 Dec 2025
 * @version 1.0
 */

@SuppressWarnings("serial")
@Setter
@Getter
public class WebBffException extends RuntimeException {
	private final String message;
	private final String errorCode;
	private final int status;
	private final String timestamp;

	public WebBffException(String msg, String errorCode, int status, String timestamp) {
		super(msg);
		this.message = msg;
		this.errorCode = errorCode;
		this.status = status;
		this.timestamp = timestamp;
	}
}