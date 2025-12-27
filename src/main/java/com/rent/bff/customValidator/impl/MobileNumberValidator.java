package com.rent.bff.customValidator.impl;

import java.util.regex.Pattern;

import com.rent.bff.customValidator.ValidMobile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 27 Dec 2025
 * @version 1.0
 */
public class MobileNumberValidator implements ConstraintValidator<ValidMobile, String> {

	private static final Pattern MOBILE_PATTERN = Pattern.compile("^[6-9]\\d{9}$");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value == null || value.isBlank()) {
			return false;
		}

		return MOBILE_PATTERN.matcher(value).matches();
	}
}