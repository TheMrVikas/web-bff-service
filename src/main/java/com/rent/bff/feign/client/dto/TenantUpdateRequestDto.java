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
public class TenantUpdateRequestDto {

    private String parentMobile;
    private String currentLocation;
    private boolean active;
}