package com.stunstun.spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stunstun
 *
 * https://github.com/wjdsupj
 * 
 */
@RestController
public class UserController {

	@RequestMapping(value = "/users/{name}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String name) {
		User user = new User();
		user.setName(name);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
