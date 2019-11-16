package com.lucas.rest.webservices.restfulwebservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.rest.webservices.restfulwebservices.models.Post;
import com.lucas.rest.webservices.restfulwebservices.repositorys.PostRepository;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/posts")
	public List<Post> findAll() {
		return this.postRepository.findAll();
	}

}
