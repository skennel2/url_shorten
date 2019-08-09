package com.example.demo.urlshorten.controller;

public interface ShortenUrlKeyManager {
	String getKeyByUrl(String originalUrl);

	String getOriginalUrl(String key);
}