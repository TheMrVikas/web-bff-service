package com.rent.bff.dto;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 27 Dec 2025
 * @version 1.0
 */
@Data
public class ApiErrorResponse {
    private String message;
    private String errorCode;
    private int status;
    private LocalDateTime timestamp;
}
