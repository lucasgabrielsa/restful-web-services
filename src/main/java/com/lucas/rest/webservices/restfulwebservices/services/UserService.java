package com.lucas.rest.webservices.restfulwebservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.lucas.rest.webservices.restfulwebservices.models.User;

@Component
public class UserService {

	private static List<User> users = new ArrayList<User>();
	
	private static Integer counter = 0;
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Lucas", new Date()));
		users.add(new User(3, "Jhon", new Date()));
		counter = 3;
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findOne(Integer id) {
		List<User> result = users.stream().filter(e-> e.getId().equals(id)).collect(Collectors.toList());
		return result.isEmpty() ? null : result.get(0);
	}
	
	public User save(User user) {
		user.setId(++counter);
		users.add(user);	 
		return user;
	}
	
	public void delete(Integer id) {
		List<User> result = users.stream().filter(e-> e.getId().equals(id)).collect(Collectors.toList());
		if(!result.isEmpty()) {
			users.remove(result.get(0));
		}
	}
	
}
