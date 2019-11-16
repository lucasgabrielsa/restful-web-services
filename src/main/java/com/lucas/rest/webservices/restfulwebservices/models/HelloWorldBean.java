package com.lucas.rest.webservices.restfulwebservices.models;

public class HelloWorldBean {
	
	private String message;
	private String name;

	public HelloWorldBean(String message) {		
		this.message = message;
	}

	public HelloWorldBean(String string, String name) {
		this.message = message;
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {		
		return String.format("[Hello World Bean] Message=%s", this.message);
	}
	
}
