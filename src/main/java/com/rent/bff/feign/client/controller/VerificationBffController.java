package com.rent.bff.feign.client.controller;

import java.util.Objects;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rent.bff.feign.client.VerificationFeignClient;
import com.rent.bff.feign.client.dto.EmailGenerateRequest;
import com.rent.bff.feign.client.dto.EmailVerifyRequest;
import com.rent.bff.feign.client.dto.OtpVerifyRequest;

import jakarta.validation.Valid;
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
	
	@PostMapping(value = "/gen-otp",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> generateOtp(@Valid @RequestBody OtpVerifyRequest request) {
		String otp = verificationFeignClient.generateOtp(request);
		return Objects.nonNull(otp)?ResponseEntity.ok(otp):ResponseEntity.internalServerError().build();
	}
	
	@PostMapping(value = "/verify-otp",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> verifyOtp(@Valid @RequestBody OtpVerifyRequest request){
		String verifyOtp = verificationFeignClient.verifyOtp(request);
		return Objects.nonNull(verifyOtp)?ResponseEntity.ok(verifyOtp):ResponseEntity.internalServerError().build();
	}
	
	@PostMapping(value = "/gen-email", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> generateEmail(@Valid @RequestBody EmailGenerateRequest request) {
		String email = verificationFeignClient.generateEmail(request);
		return Objects.nonNull(email)?ResponseEntity.ok(email):ResponseEntity.internalServerError().build();
	}
	
	@PostMapping(value = "/verify-email", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> verifyEmail(@Valid @RequestBody EmailVerifyRequest request) {
		String verifyEmail = verificationFeignClient.verifyEmail(request);
		return Objects.nonNull(verifyEmail)?ResponseEntity.ok(verifyEmail):ResponseEntity.internalServerError().build();
	}
}
