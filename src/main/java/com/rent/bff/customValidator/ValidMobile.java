package com.rent.bff.customValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.rent.bff.customValidator.impl.MobileNumberValidator;

import com.rent.bff.customValidator.impl.MobileNumberValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 27 Dec 2025
 * @version 1.0
 */
@Documented
@Constraint(validatedBy = MobileNumberValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMobile {

    String message() default "Invalid mobile number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}