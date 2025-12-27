package com.rent.bff.feign.client.dto;

import com.rent.bff.enums.Gender;

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
public class TenantCreateRequestDto {

    private String fullName;
    private Gender gender;

    private String email;
    private String mobileNumber;

    // identity (raw value – hash service me banega)
    private String aadhaarNumber;
    private String panNumber;

    // parent / guardian
    private String parentName;
    private String parentMobile;

    private String nativeLocation;
    private String currentLocation;
}