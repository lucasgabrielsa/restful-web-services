package com.lucas.rest.webservices.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.rest.webservices.restfulwebservices.models.Name;
import com.lucas.rest.webservices.restfulwebservices.models.PersonV1;
import com.lucas.rest.webservices.restfulwebservices.models.PersonV2;

@RestController
public class PersonControllerVersioning {
	
	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Jhon Brown");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Jhon", "Brown"));
	}
	
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 personV1Param() {
		return new PersonV1("Jhon Brown");
	}
	
	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 personV2Param() {
		return new PersonV2(new Name("Jhon", "Brown"));
	}
	
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 personV1Header() {
		return new PersonV1("Jhon Brown");
	}
	
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 personV2Header() {
		return new PersonV2(new Name("Jhon", "Brown"));
	}
	
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 personV1Producer() {
		return new PersonV1("Jhon Brown");
	}
	
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 personV2Producer() {
		return new PersonV2(new Name("Jhon", "Brown"));
	}

}
