package com.jce.mvc.commons.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonEncoding;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17. - initial
 * @date 2012. 11. 14. - Object error fixed
 */

public class JSONPView extends MappingJacksonJsonView {

	private final String DEFAULT_CONTENT_TYPE = "application/javascript";
	private final String METHOD = "GET";
	private final String JSONP_CALLBACK = "callback";
	
	private JsonEncoding encoding;
	private boolean disableCaching;
	
	public JSONPView() {
		setContentType(DEFAULT_CONTENT_TYPE);
		encoding = JsonEncoding.UTF8;
		disableCaching = true;
	}
	
	@Override
	protected void prepareResponse(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType(getContentType());
		response.setCharacterEncoding(encoding.getJavaName());
		
		if (disableCaching) {
			response.addHeader("Pragma", "no-cache");
			response.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
			response.addDateHeader("Expires", 1L);
		}
	}
	
	/**
	 * AbstractView - (inherit) - MappingJacksonJsonView - (inherit) - JSONPView
	 * @render method is overrided by AbstractView
	 */
	
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// jsonp method require method type GET
		if(!( request.getMethod().toUpperCase().equals(METHOD) )) {
			super.render(model, request, response);
			return;
		}
		
		// require callback parameter
		String callback = (request.getParameter(JSONP_CALLBACK) != null ? request.getParameter(JSONP_CALLBACK) : "?");
		
		response.getOutputStream().write(new String(callback + "(").getBytes());
		super.render(model, request, response);
		response.getOutputStream().write(new String(");").getBytes());
		
	}
}