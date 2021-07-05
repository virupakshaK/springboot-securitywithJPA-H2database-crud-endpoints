package com.spring.veeru.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author virupaksha.kuruva
 *
 */
@RestController
@RequestMapping("/test")
public class TestServiceController {

	@GetMapping("/greetings")
	public String getGreetingsMessage() {
		return "Welcome to Spring boot world.";
	}
	
}
