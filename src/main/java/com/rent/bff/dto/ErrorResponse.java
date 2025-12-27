package com.rent.bff.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 27 Dec 2025
 * @version 1.0
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ErrorResponse {
    private String message;
    private String errorCode;
    private int status;
    private String timestamp;
}
