package com.rent.bff.verification.controller;

import java.util.Objects;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rent.bff.feign.client.VerificationFeignClient;
import com.rent.bff.verification.dto.OtpVerifyRequest;

import lombok.RequiredArgsConstructor;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 26 Dec 2025
 * @version 1.0
 */
@RestController
@RequestMapping(value = {"/api/v1/verification"})
@RequiredArgsConstructor
public class VerificationBffController {
	
	private final VerificationFeignClient verificationFeignClient;
	
	@GetMapping()
	public String getWelcomeMsgBff() {
		return verificationFeignClient.getWelcomeMsg();
	}
	
	@PostMapping(value = "/get-otp",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> generateOtp(@RequestBody OtpVerifyRequest request) {
		String otp = verificationFeignClient.generateOtp(request);
		return Objects.nonNull(otp)?ResponseEntity.ok(otp):ResponseEntity.internalServerError().build();
	}
	
	@PostMapping(value = "/verify-otp",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> verifyOtp(@RequestBody OtpVerifyRequest request){
		String verifyOtp = verificationFeignClient.verifyOtp(request);
		return Objects.nonNull(verifyOtp)?ResponseEntity.ok(verifyOtp):ResponseEntity.internalServerError().build();
	}
	
}
