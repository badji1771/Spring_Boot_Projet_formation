package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndPoint {

	@GetMapping("/say")
	String sayHello() {
		return "Hello";
	}
}
