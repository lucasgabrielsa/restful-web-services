package com.lucas.rest.webservices.restfulwebservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.rest.webservices.restfulwebservices.controllers.models.User;
import com.lucas.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import com.lucas.rest.webservices.restfulwebservices.services.UserService;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

@RestController
public class UserController {	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> findAll() {
		return this.userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findOne(@PathVariable Integer id) {
		User user = this.userService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("Id="+ id);
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> save(@Valid @RequestBody User user) {				
		User userSaved = this.userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId()).toUri(); 
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Integer id) {
		User user = this.userService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("Id="+ id);
		}
		this.userService.delete(id);	
	}

}
