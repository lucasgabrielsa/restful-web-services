package com.lucas.rest.webservices.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.rest.webservices.restfulwebservices.controllers.models.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/hello-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/hello-bean/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {	
		return new HelloWorldBean("Hello World", name);
	}

}
