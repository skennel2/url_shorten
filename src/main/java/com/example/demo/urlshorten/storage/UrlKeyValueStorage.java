package com.example.demo.urlshorten.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.demo.urlshorten.service.UrlStorage;

@Component
public class UrlKeyValueStorage implements UrlStorage {

	private Map<String, String> storage;

	public UrlKeyValueStorage() {
		storage = new ConcurrentHashMap<>();
	}

	@Override
	public void store(String key, String originalUrl) {
		storage.put(key, originalUrl);
	}

	@Override
	@Nullable
	public String getByKey(String key) {
		return storage.get(key);
	}

	@Override
	public boolean hasKey(String key) {
		return storage.containsKey(key);
	}
}
