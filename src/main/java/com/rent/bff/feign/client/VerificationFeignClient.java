package com.rent.bff.feign.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rent.bff.config.FeignConfig;
import com.rent.bff.feign.client.dto.EmailGenerateRequest;
import com.rent.bff.feign.client.dto.EmailVerifyRequest;
import com.rent.bff.feign.client.dto.OtpVerifyRequest;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 26 Dec 2025
 * @version 1.0
 */
@FeignClient(name = "08-VERIFICATION-SERVICE",configuration = FeignConfig.class)
public interface VerificationFeignClient {
	/**
	 * 
	 * @param request
	 * @return
	 * TODO
	 * ResponseEntity<String>
	 */
	@PostMapping(value = "/verification/otp/verify", produces = MediaType.APPLICATION_JSON_VALUE)
	public String verifyOtp(@RequestBody OtpVerifyRequest request);
	
	/**
	 * 
	 * @param request
	 * @return
	 * TODO
	 * String
	 */
	@PostMapping(value = "/verification/email/verify", produces = MediaType.APPLICATION_JSON_VALUE)
	public String verifyEmail(@RequestBody EmailVerifyRequest request);

	/**
	 * 
	 * @param mobile
	 * @param email
	 * @return
	 * TODO
	 * Map<String,Boolean>
	 */
	@GetMapping(value = "/verification/status", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Boolean> isFullyVerified(@RequestParam(name = "mobile") String mobile,
			@RequestParam(name = "email") String email);

	/**
	 * 
	 * @param request
	 * @return
	 * TODO
	 * String
	 */
	@PostMapping(value = "/generate/email", produces = MediaType.APPLICATION_JSON_VALUE)
	public String generateEmail(@RequestBody EmailGenerateRequest request);

	/**
	 * 
	 * @param request
	 * @return
	 * TODO
	 * String
	 */
	@PostMapping(value = "/generate/otp", produces = MediaType.APPLICATION_JSON_VALUE)
	public String generateOtp(@RequestBody OtpVerifyRequest request);
	
	@GetMapping("/generate/welcome")
	public String getWelcomeMsg();
}
