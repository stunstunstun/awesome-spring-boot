/**
 * 
 */
package com.stunstun.spring;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stunstun.spring.support.Fixtures;

/**
 * @author stunstun
 *
 * https://github.com/wjdsupj
 */
public class UserTests {

	@Test
	public void shoulBeCreateUser() throws JsonParseException, JsonMappingException, IOException {
		String jsonString = Fixtures.load("/fixtures/user.json");
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(jsonString, User.class);
		
		assertThat(user.getName(), is("stunstun"));
	}
}
