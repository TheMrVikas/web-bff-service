package com.rent.bff.dto;

import lombok.Getter;

/**
 * Description: this class is responsible for TODO vikas
 * 
 * @created on 27 Dec 2025
 * @version 1.0
 */
@Getter
public class ExceptionMessage {
	private String timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	private String errorCode;
}
