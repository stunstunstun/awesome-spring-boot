package com.jce.commons.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.view.AbstractView;

public class JSONPView extends AbstractView {

	public static final String DEFAULT_CONTENT_TYPE = "javascript/jsonp";
	private ObjectMapper objectMapper;
	private JsonEncoding encoding;
	private boolean disableCaching;
	
	public JSONPView() {
		objectMapper = new ObjectMapper();
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
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		model.remove("org.springframework.validation.BindingResult.loginSession");
		String callback = request.getParameter("callback") != null ? request.getParameter("callback"):"?";
		String json = objectMapper.writeValueAsString(model);
		
		response.setContentType("javascript/jsonp");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(callback+"("+json+");");
	}
}
