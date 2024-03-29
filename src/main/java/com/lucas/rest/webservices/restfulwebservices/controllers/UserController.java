package com.lucas.rest.webservices.restfulwebservices.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import com.lucas.rest.webservices.restfulwebservices.models.Post;
import com.lucas.rest.webservices.restfulwebservices.models.User;
import com.lucas.rest.webservices.restfulwebservices.repositorys.PostRepository;
import com.lucas.rest.webservices.restfulwebservices.repositorys.UserRepository;
import com.lucas.rest.webservices.restfulwebservices.services.UserService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
public class UserController {	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;	
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/users")
	public List<User> findAll() {
//		return this.userService.findAll();
		return this.userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Resource<User> findOne(@PathVariable Integer id) {
//		User user = this.userService.findOne(id);
		
		Optional<User> user = this.userRepository.findById(id);
		
//		if(user == null) {
		if(!user.isPresent()) {
			throw new UserNotFoundException("Id="+ id);
		}
		//HATEOAS CONCEPT		
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).findAll());
		resource.add(link.withRel("findAll"));
		
		return resource;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> save(@Valid @RequestBody User user) {				
//		User userSaved = this.userService.save(user);
		
		User userSaved = this.userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId()).toUri(); 
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Integer id) {
//		User user = this.userService.findOne(id);
		Optional<User> user = this.userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("Id="+ id);
		}
//		this.userService.delete(id);
		this.userRepository.delete(user.get());
	}
	
	
	
	@GetMapping("/users/{id}/posts")
	public List<Post> findPostsByUserId(@PathVariable Integer id) {
		Optional<User> user = this.userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("Id="+ id);
		}		
		return user.get().getPosts();
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> save(@RequestBody Post post, @PathVariable int id) {
		Optional<User> user = this.userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("Id="+ id);
		}	
		post.setUser(user.get());
		Post postSaved = this.postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand(id).toUri(); 
		return ResponseEntity.created(location).build();		
	}

}
