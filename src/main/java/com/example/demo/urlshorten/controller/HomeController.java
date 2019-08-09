package com.example.demo.urlshorten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
	private ShortenUrlKeyManager keyManager;

	@RequestMapping("/{urlKey}")
	public String redirectToOriginalUrl(@PathVariable String urlKey) {
		String originalUrl = keyManager.getOriginalUrl(urlKey);
		return "redirect:" + originalUrl;
	}

}
