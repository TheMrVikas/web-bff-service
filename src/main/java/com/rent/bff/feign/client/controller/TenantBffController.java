package com.rent.bff.feign.client.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rent.bff.feign.client.TenantFeignClient;
import com.rent.bff.feign.client.dto.TenantCreateRequestDto;
import com.rent.bff.feign.client.dto.TenantResponseDto;
import com.rent.bff.feign.client.dto.TenantUpdateRequestDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 27 Dec 2025
 * @version 1.0
 */
@Tag(
	    name = "Tenant APIs",
	    description = "APIs for Tenant creation, update, fetch and deactivation"
	)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tenants")
public class TenantBffController {

	private final TenantFeignClient tenantFeignClient;

	@Operation(summary = "Create Tenant", description = "Creates a tenant only if mobile and email are verified", responses = {
			@ApiResponse(responseCode = "201", description = "Tenant created successfully", content = @Content(schema = @Schema(implementation = TenantResponseDto.class))),
			@ApiResponse(responseCode = "400", description = "Validation or verification failed"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TenantResponseDto> createTenant(@RequestBody TenantCreateRequestDto request) {
		TenantResponseDto response = tenantFeignClient.createTenant(request);
		return Objects.nonNull(response) ? ResponseEntity.status(HttpStatus.CREATED).body(response)
				: ResponseEntity.internalServerError().build();
	}

	@Operation(summary = "Get Tenant by UID", description = "Fetch tenant details using tenant UID", responses = {
			@ApiResponse(responseCode = "200", description = "Tenant found", content = @Content(schema = @Schema(implementation = TenantResponseDto.class))),
			@ApiResponse(responseCode = "204", description = "Tenant not found") })
	@GetMapping(value = "/{tenantUid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TenantResponseDto> getTenantByUid(@PathVariable("tenantUid") String tenantUid) {
		TenantResponseDto response = tenantFeignClient.getTenantByUid(tenantUid);
		return Objects.nonNull(response) ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
	}

	@Operation(summary = "Update Tenant", description = "Updates non-identity tenant fields only", responses = {
			@ApiResponse(responseCode = "200", description = "Tenant updated successfully", content = @Content(schema = @Schema(implementation = TenantResponseDto.class))),
			@ApiResponse(responseCode = "400", description = "Invalid update request"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@PutMapping(value = "/{tenantUid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TenantResponseDto> updateTenant(@PathVariable("tenantUid") String tenantUid,
			@RequestBody TenantUpdateRequestDto request) {
		TenantResponseDto response = tenantFeignClient.updateTenant(tenantUid, request);
		return Objects.nonNull(response) ? ResponseEntity.ok(response) : ResponseEntity.internalServerError().build();
	}

	@Operation(summary = "Deactivate Tenant", description = "Soft deletes (deactivates) a tenant", responses = {
			@ApiResponse(responseCode = "200", description = "Tenant deactivated successfully"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@DeleteMapping("/{tenantUid}")
	public ResponseEntity<String> deactivateTenant(@PathVariable("tenantUid") String tenantUid) {
		String deactivateTenant = tenantFeignClient.deactivateTenant(tenantUid);
		return Objects.nonNull(deactivateTenant) ? ResponseEntity.ok(deactivateTenant)
				: ResponseEntity.internalServerError().build();
	}
}