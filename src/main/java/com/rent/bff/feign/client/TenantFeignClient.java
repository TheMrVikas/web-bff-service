package com.rent.bff.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rent.bff.config.FeignConfig;
import com.rent.bff.feign.client.dto.TenantCreateRequestDto;
import com.rent.bff.feign.client.dto.TenantResponseDto;
import com.rent.bff.feign.client.dto.TenantUpdateRequestDto;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 27 Dec 2025
 * @version 1.0
 */
@FeignClient(name = "04-TENANT-SERVICE",path = "/tenants",configuration = FeignConfig.class)
public interface TenantFeignClient {
	
	@PostMapping()
	public TenantResponseDto createTenant(@RequestBody TenantCreateRequestDto request);

	@GetMapping(value = "/{tenantUid}")
	public TenantResponseDto getTenantByUid(@PathVariable("tenantUid") String tenantUid);
	
	@PutMapping(value = "/{tenantUid}")
	public TenantResponseDto updateTenant(@PathVariable("tenantUid") String tenantUid,
			@RequestBody TenantUpdateRequestDto request);

	@DeleteMapping("/{tenantUid}")
	public String deactivateTenant(@PathVariable("tenantUid") String tenantUid);

}
