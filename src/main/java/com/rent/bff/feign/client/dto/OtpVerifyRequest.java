package com.rent.bff.feign.client.dto;

import com.rent.bff.customValidator.ValidMobile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 26 Dec 2025
 * @version 1.0
 */
@Data
public class OtpVerifyRequest {
	@NotBlank(message = "Mobile number is required")
	@ValidMobile
    private String mobile;
    private String otp;
}