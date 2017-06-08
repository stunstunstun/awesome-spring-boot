package com.stunstun.spring.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stunstun.spring.common.support.ResourceNotFoundException;
import com.stunstun.spring.repository.entity.User;
import com.stunstun.spring.user.support.UserService;

/**
 * @author stunstun
 *
 */
@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET, produces =  "application/json")
	public @ResponseBody ResponseEntity<List<User>> getList() {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<User> create(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<User> getEntity(@PathVariable Long id) {
		return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
		User entity = userService.getUser(id);
		if (entity == null) {
			throw new ResourceNotFoundException();
		}
		user.setId(id);
		userService.updateUser(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
