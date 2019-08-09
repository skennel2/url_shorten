package com.example.demo.urlshorten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	private ShortenUrlKeyManager keyManager;

	@GetMapping("/index")
	public ModelAndView index() {	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		mv.addObject("result_url", "");
		
		return mv;
	}
	
	@GetMapping("/{urlKey}")
	public String redirectToOriginalUrl(@PathVariable String urlKey) {
		String originalUrl = keyManager.getOriginalUrl(urlKey);
		return "redirect:" + originalUrl;
	}
	
	@PostMapping("/convert")
	public ModelAndView receiveUrl(@RequestParam String urlvalue) {
		String resultURL = keyManager.getKeyByUrl(urlvalue);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		mv.addObject("result_url", "http://localhost:8080/" + resultURL);
		return mv;
	}

}
