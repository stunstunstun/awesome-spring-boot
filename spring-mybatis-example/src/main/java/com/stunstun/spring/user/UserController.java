/**
 * 
 */
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
@RequestMapping("/account")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/v1/users", method = RequestMethod.POST, headers = {"Content-Type=application/json"})
	public @ResponseBody void add(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(value = "/v1/users", method = RequestMethod.GET, headers = {"Content-Type=application/json"})
	public @ResponseBody ResponseEntity<List<User>> getList() {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/v1/users/{id}", method = RequestMethod.GET, headers = {"Content-Type=application/json"})
	public @ResponseBody ResponseEntity<User> getEntity(@PathVariable Long id) {
		User entity = userService.getUser(id);
		if (entity == null) {
			throw new ResourceNotFoundException();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/v1/users/{id}", method = RequestMethod.PUT, headers = {"Content-Type=application/json"})
	public @ResponseBody void update(@PathVariable Long id, @RequestBody User user) {
		User entity = userService.getUser(id);
		if (entity == null) {
			throw new ResourceNotFoundException();
		}
		user.setId(id);
		userService.updateUser(user);
	}
	
	@RequestMapping(value = "/v1/users/{id}", method = RequestMethod.DELETE, headers = {"Content-Type=application/json"})
	public @ResponseBody void delete(@PathVariable Long id) {
		User entity = userService.getUser(id);
		if (entity == null) {
			throw new ResourceNotFoundException();
		}
		userService.deleteUser(entity);
	}
}
