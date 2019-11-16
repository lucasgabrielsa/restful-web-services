package com.lucas.rest.webservices.restfulwebservices.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.rest.webservices.restfulwebservices.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
