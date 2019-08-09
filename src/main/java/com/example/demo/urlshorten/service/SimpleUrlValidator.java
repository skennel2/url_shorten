package com.example.demo.urlshorten.service;

import org.springframework.stereotype.Component;

@Component
public class SimpleUrlValidator implements UrlValidator {

	private final String HTTP = "HTTP://";
	private final String HTTPS = "HTTPS://";
	
	@Override
	public boolean isValidate(String url) {
		return url.toUpperCase().startsWith(HTTP) || 
				url.toUpperCase().startsWith(HTTPS);
	}

}
