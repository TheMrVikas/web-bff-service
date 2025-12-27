package com.rent.bff.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 27 Dec 2025
 * @version 1.0
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DownstreamErrorResponse {

    private String message;
    private int status;
    private String path;
    private String error;
    private String timestamp;
}