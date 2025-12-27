package com.rent.bff.config;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rent.bff.exception.DownstreamErrorResponse;
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

	private final ObjectMapper mapper = new ObjectMapper();

	/*@Override
	public Exception decode(String methodKey, Response response) {
		try {
			ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);

			// Return a clean exception with just the message
			return new WebBffException(errorResponse.getMessage(), errorResponse.getErrorCode(),
					errorResponse.getStatus(), errorResponse.getTimestamp());

		} catch (IOException e) {
			return new RuntimeException("Unknown error occurred");
		}
	}*/
	
	/*@Override
    public Exception decode(String methodKey, Response response) {

        int status = response.status();
        String body = null;

        try {
            if (response.body() != null) {
                body = new String(response.body().asInputStream().readAllBytes(),
                        StandardCharsets.UTF_8);
            }

            // 1️⃣ Try parsing standard error response
            if (body != null && body.startsWith("{")) {
                try {
                    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
                    return new WebBffException(
                            error.getMessage(),
                            error.getErrorCode(),
                            error.getStatus() != 0 ? error.getStatus() : status,
                            error.getTimestamp()
                    );
                } catch (Exception ignore) {
                    // fall through
                }
            }

            // 2️⃣ Fallback – readable message
            return new WebBffException(
                    resolveMessage(body, status),
                    "DOWNSTREAM_ERROR",
                    status,
                    LocalDateTime.now().toString()
            );

        } catch (Exception ex) {
            return new WebBffException(
                    "Downstream service error",
                    "DOWNSTREAM_ERROR",
                    status,
                    LocalDateTime.now().toString()
            );
        }
    }

    private String resolveMessage(String body, int status) {
        if (body != null && !body.isBlank()) {
            return body;
        }
        return switch (status) {
            case 400 -> "Bad request to downstream service";
            case 404 -> "Resource not found";
            case 500 -> "Internal server error from downstream service";
            default -> "Downstream service error";
        };
    }*/
	
	@Override
    public Exception decode(String methodKey, Response response) {

        try {
            String body = new String(
                    response.body().asInputStream().readAllBytes(),
                    StandardCharsets.UTF_8
            );

            if (body.startsWith("\"{")) {
                body = mapper.readValue(body, String.class);
            }

            DownstreamErrorResponse error =
                    mapper.readValue(body, DownstreamErrorResponse.class);

            return new WebBffException(error);

        } catch (Exception e) {
            DownstreamErrorResponse fallback = new DownstreamErrorResponse();
            fallback.setMessage("Downstream service error");
            fallback.setStatus(response.status());
            fallback.setError("Internal Server Error");
            fallback.setTimestamp(LocalDateTime.now().toString());
            return new WebBffException(fallback);
        }
    }
    @Data
    public static class ErrorResponse {
        private String message;
        private String errorCode;
        private int status;
        private String timestamp;
    }
}

