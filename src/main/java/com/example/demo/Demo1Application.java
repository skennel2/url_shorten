package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.urlshorten.service.UrlStorage;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {

	@Autowired
	private UrlStorage storage;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		storage.store("1111", "http://www.naver.com");
		storage.store("2222", "https://github.com");
	}

}
