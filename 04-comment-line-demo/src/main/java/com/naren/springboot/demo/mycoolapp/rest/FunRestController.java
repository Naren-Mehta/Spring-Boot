package com.naren.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Welcome to first Spring boot application - "+ LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String dailyWorkout() {
		System.out.println("=========in controller======");
		return "Run for victory "+ LocalDateTime.now();
	}
	
	@GetMapping("/wishes")
	public String dailyWishes() {
		System.out.println("=========in controller======");
		return "<h1>All the best "+ LocalDateTime.now() +"</h1>";
	}

}
