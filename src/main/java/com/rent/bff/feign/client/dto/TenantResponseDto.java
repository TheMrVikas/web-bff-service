package com.rent.bff.feign.client.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 27 Dec 2025
 * @version 1.0
 */
@Getter
@Setter
public class TenantResponseDto {

    private String tenantUid;
    private String fullName;
    private String email;
    private String mobileNumber;
    private String parentName;
    private String parentMobile;
    private String nativeLocation;
    private String currentLocation;
}