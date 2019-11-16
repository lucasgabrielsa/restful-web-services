package com.lucas.rest.webservices.restfulwebservices.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.rest.webservices.restfulwebservices.models.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/hello-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	/*
	 * without the request header
	 */
	@GetMapping("/hello-internationalized-easy")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
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
