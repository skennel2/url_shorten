package com.example.demo.urlshorten.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.urlshorten.controller.ShortenUrlKeyManager;

@Component
public class KeyValueStorageBaseShortenUrlService implements ShortenUrlKeyManager {

	private UrlKeyGenerator keyGanerator;

	private UrlStorage urlStorage;

	private UrlValidator urlValidator;

	@Autowired
	public KeyValueStorageBaseShortenUrlService(UrlKeyGenerator UrlShortener, UrlStorage UrlStorage,
			UrlValidator urlValidator) {
		this.urlValidator = urlValidator;
		this.keyGanerator = UrlShortener;
		this.urlStorage = UrlStorage;
	}

	@Override
	public String getKeyByUrl(String originalUrl) {
		if (!urlValidator.isValidate(originalUrl)) {
			throw new IllegalArgumentException(originalUrl);
		}

		String key = keyGanerator.getKeyUsingUrl(originalUrl);
		urlStorage.store(key, originalUrl);

		return key;
	}

	@Override
	public String getOriginalUrl(String shortenUrl) {
		String result = urlStorage.getByKey(shortenUrl);

		if (Objects.isNull(result)) {
			throw new RuntimeException("해당하는 Url이 존재하지 않습니다.");
		}

		return result;
	}
}