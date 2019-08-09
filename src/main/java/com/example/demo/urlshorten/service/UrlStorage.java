package com.example.demo.urlshorten.service;

public interface UrlStorage {
	void store(String key, String originalUrl);
	String getByKey(String key);
	boolean hasKey(String key);
}