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
	private String message;
	private String errorCode;
	private int status;
	private String timestamp;
	private String url;
	private String path;
	private String error;
	
	private DownstreamErrorResponse errorr;

    public WebBffException(DownstreamErrorResponse errorr) {
        super(errorr.getMessage());
        this.errorr = errorr;
    }
	
	public WebBffException(String msg, String errorCode, int status, String timestamp,String url,String path,String error) {
		super(msg);
		this.message = msg;
		this.errorCode = errorCode;
		this.status = status;
		this.timestamp = timestamp;
		this.url=url;
		this.path = path;
		this.error = error;
	}
	
	public WebBffException(String msg, String errorCode, int status, String timestamp) {
		super(msg);
		this.message = msg;
		this.errorCode = errorCode;
		this.status = status;
		this.timestamp = timestamp;
	}
}