package com.lucas.rest.webservices.restfulwebservices;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lucas.rest.webservices.restfulwebservices.models.User;
import com.lucas.rest.webservices.restfulwebservices.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulWebServicesApplicationTests {
	
	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testUserFound() {
		User user = userService.findOne(1);
		assertNotNull(user);
	}

}
