package com.stunstun.spring.support;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

/**
 * @author stunstun
 *
 */
public class Fixtures {
	
	public static String load(String path) {
		try {
			InputStream stream = new ClassPathResource(path, Fixtures.class).getInputStream();
			return StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
