package com.naren.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String sayHello() {
		System.out.println("=========in controller======");
		return "Welcome to first Spring boot application - "+ LocalDateTime.now();
	}

}
