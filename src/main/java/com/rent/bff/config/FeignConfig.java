package com.rent.bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.ErrorDecoder;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 27 Dec 2025
 * @version 1.0
 */
@Configuration
public class FeignConfig {

    
    @Bean
    ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }
}