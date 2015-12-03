/**
 * 
 */
package com.stunstun.spring;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.stunstun.spring.support.Fixtures;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public class FixturesTests {

	@Test
	public void shouldBeUseCommonTestSources() {
		String jsonString = Fixtures.load("/fixtures/user.json");
		System.out.println(jsonString);
		assertThat(jsonString, notNullValue());
	}
}
