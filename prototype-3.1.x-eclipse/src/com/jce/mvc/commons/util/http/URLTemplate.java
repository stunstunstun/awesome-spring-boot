package com.jce.mvc.commons.util.http;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 11. 19.
 */

public class URLTemplate {
	
	private String url;
	private Map<String, Object> parameters;
	private String queryString;
	private static final String AMPERSAND_SEPARATED_STRING = "%s?%s";
	
	public URLTemplate(String url) {
		this.url = url;
		this.parameters = new HashMap<String, Object>();
	}
	
	public void addParameter(String key, Object value) {
		parameters.put(key, value);
	}
	
	public String extract() {
		queryString = this.getSortedAndEncodedParams();
		return String.format(AMPERSAND_SEPARATED_STRING, url, queryString);
	}
	
	private String getSortedAndEncodedParams() {
		
		StringBuilder out = new StringBuilder();
		TreeSet<String> keys = new TreeSet<String>(this.parameters.keySet());
		
		for (String key : keys) {
			Object value = this.parameters.get(key);
			out.append( key + "=" + value + "&");
		}
		return out.toString().substring(0, out.toString().length() - 1);
	}
	
	public String getURL() {
		return url;
	}
	
	public Map<String, Object> getParameters() {
		return parameters;
	}

}
