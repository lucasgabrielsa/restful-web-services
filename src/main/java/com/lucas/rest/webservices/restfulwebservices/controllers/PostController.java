package com.lucas.rest.webservices.restfulwebservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.rest.webservices.restfulwebservices.models.Post;
import com.lucas.rest.webservices.restfulwebservices.repositorys.PostRepository;

import javassist.NotFoundException;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/posts")
	public List<Post> findAll() {
		return this.postRepository.findAll();
	}
	
	@GetMapping("/posts/{id}")
	public Post findById(@PathVariable int id) throws NotFoundException {
		Optional<Post> post = this.postRepository.findById(id);
		if(!post.isPresent()) {
			throw new NotFoundException("Post ="+ id);
		}
		return post.get();
	}
	
}
