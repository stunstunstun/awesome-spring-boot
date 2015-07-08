package com.jce.test.util.http;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import com.jce.mvc.commons.annotation.OnlyTestComponent;
import com.jce.mvc.commons.util.http.HttpTemplate;
import com.jce.mvc.commons.util.http.URLTemplate;

@OnlyTestComponent
public class JSONHandleTest {

	@Test
	public void jsonHandle() throws Exception {
		
		URLTemplate template = new URLTemplate("http://api.twitter.com/1/users/show.json");
		template.addParameter("user_id", "10330576396");
		template.addParameter("screen_name", "apigee");
		template.addParameter("garbage", 0);
		System.out.println("request path:" + template.extract());
		
		String jsonData = HttpTemplate.getInstance().get(template);
		System.out.println("JSON:" + jsonData);
		
		// convert json data to map data
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> mapData = mapper.readValue(jsonData, new TypeReference<Map<String, Object>>() {});
		System.out.println(mapData);
	}
}
