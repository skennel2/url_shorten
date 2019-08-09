package com.example.demo.urlshorten.shortner;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.demo.urlshorten.service.UrlKeyGenerator;

@Component
public class UUIDKeyGenerator implements UrlKeyGenerator {
	@Override
	public String getKeyUsingUrl(String originalUrl) {
		if (originalUrl == null) {
			throw new NullPointerException("originalUrl");
		}

		return UUID.fromString(originalUrl).toString();
	}
}
