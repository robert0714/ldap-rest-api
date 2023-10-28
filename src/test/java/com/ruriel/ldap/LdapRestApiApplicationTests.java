package com.ruriel.ldap;
 
import java.util.List;

import javax.naming.InvalidNameException;

import static org.junit.jupiter.api.Assertions.*;
 
 
import org.junit.jupiter.api.*; 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest; 
 
import com.ruriel.ldap.model.User;
import com.ruriel.ldap.repository.UserService;

@SpringBootTest 
class LdapRestApiApplicationTests {

	@Autowired
	private UserService userService;

	@AfterEach
	void removeUser() {
		userService.delete("Beta");
	}

	@Test
	void testSaveUser() {
		User persisted;
		User user = new User();
		user.setCn("Testing pilot");
		user.setSn("Testing");
		user.setUid("Beta");
		try {
			persisted = userService.create(user);
		} catch (InvalidNameException e) {
			e.printStackTrace();
			persisted = null;
		}
		assertNotNull(persisted);
	}

	@Test
	void testFindByUid() {
		User user = new User();
		user.setCn("Testing pilot");
		user.setSn("Testing");
		user.setUid("Beta");
		try {
			userService.create(user);
		} catch (InvalidNameException e) {
			e.printStackTrace();
		}
		User found = userService.findByUid(user.getUid());
		assertNotNull(found );
	}

	@Test
	void testFindAll() {
		User user = new User();
		user.setCn("Testing pilot");
		user.setSn("Testing");
		user.setUid("Beta");
		try {
			userService.create(user);
		} catch (InvalidNameException e) {
			e.printStackTrace();
		}
		List<User> found = userService.findAll();
		assertTrue(found.size() > 0);
	}
	
	@Test
	void testDelete() {
		User user = new User();
		user.setCn("Testing pilot");
		user.setSn("Testing");
		user.setUid("Beta");
		try {
			userService.create(user);
		} catch (InvalidNameException e) {
			e.printStackTrace();
		}
		userService.delete(user.getUid());
		User found = userService.findByUid(user.getUid());
		assertNull(found );
	}
}
