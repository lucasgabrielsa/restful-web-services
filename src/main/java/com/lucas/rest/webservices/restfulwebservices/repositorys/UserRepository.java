package com.lucas.rest.webservices.restfulwebservices.repositorys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.rest.webservices.restfulwebservices.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {	
}
