package com.jce.test.util.http;

import org.junit.Test;

import com.jce.mvc.commons.annotation.OnlyTestComponent;
import com.jce.mvc.commons.util.http.HttpTemplate;
import com.jce.mvc.commons.util.http.URLTemplate;
import com.jce.test.AbstractContextTest;

@OnlyTestComponent
public class HttpClientTest extends AbstractContextTest {
	
	@Test
	public void request() throws Exception {
		
		/**
		 * 아래와 같은 웹페이지의 정보를 parsing 합니다.
		 * No parameter
		 * Method : GET
		 * URL
		 *  : http://fsf.joycity.com/main.jce
		 */
		
		String htmlContents = HttpTemplate.getInstance().get("http://fsf.joycity.com/main.jce", null);
		System.out.println(htmlContents);
		
		
		/**
		 * 서버에서 api를 호출에 json data를 가져옵니다.
		 * Has parameter
		 * Method : GET
		 * URL : http://api.twitter.com/1/users/show.json
		 */
		
		URLTemplate url = new URLTemplate("http://api.twitter.com/1/users/show.json");
		url.addParameter("user_id", "10330576396");
		url.addParameter("screen_name", "apigee");
		
		String jsonData = HttpTemplate.getInstance().get(url.extract(), null);
		System.out.println(jsonData);
	}
}
