package com.rent.bff.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rent.bff.exception.WebBffException;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.Data;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 27 Dec 2025
 * @version 1.0
 */
@Component
public class FeignErrorDecoder implements ErrorDecoder {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public Exception decode(String methodKey, Response response) {
		try {
			ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);

			// Return a clean exception with just the message
			return new WebBffException(errorResponse.getMessage(), errorResponse.getErrorCode(),
					errorResponse.getStatus(), errorResponse.getTimestamp());

		} catch (IOException e) {
			return new RuntimeException("Unknown error occurred");
		}
	}

    // Inner class for parsing JSON
	@Data
    public static class ErrorResponse {
        private String message;
        private String errorCode;
        private int status;
        private String timestamp;
    }
}

