package com.example.demo.urlshorten.service;

import org.springframework.stereotype.Component;

@Component
public class UrlValidatorMock implements UrlValidator {

	@Override
	public boolean isValidate(String url) {
		return true;
	}

}
