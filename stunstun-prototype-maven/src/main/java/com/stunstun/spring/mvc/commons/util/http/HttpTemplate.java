package com.stunstun.spring.mvc.commons.util.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.stunstun.spring.mvc.commons.util.encrypt.RFC3986Encoder;

/**
 * @author Jung Min Hyuck (chujinnoon@joycity.com)
 * @date 2012. 4. 23.
 * @description - HTTP Util
 */

public class HttpTemplate {

	private String DEFAULT_ACCEPT = "application/json";
	private HttpTemplate() {}
	
	private static final class HttpTemplateHolder {
		public static final HttpTemplate instance = new HttpTemplate();
	}
	
	public static HttpTemplate getInstance() {
		return HttpTemplateHolder.instance;
	}
	
	public void setAccept(String accept) {
		this.DEFAULT_ACCEPT = accept;
	}
	
    /**
     * Create URL request [ POST ]
     * @author Jung Min Hyuck (chujinnoon@joycity.com)
     * @param urlStr - request url
     * @param method - request method
     * @param postArgs - post parameter for POST request
     * @return connection response
     */
	
	public String post(URLTemplate template) throws IOException, MalformedURLException {
        
    	URL url = new URL(template.getURL());
    	
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        connection.setRequestProperty("Accept", DEFAULT_ACCEPT);
        connection.setReadTimeout(3000);
        connection.setConnectTimeout(3000);
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        
        String encodedPostArgs = encodeURLParameters(template.getParameters());
        DataOutputStream dos = new DataOutputStream(connection
                .getOutputStream());
        
        dos.writeBytes(encodedPostArgs);
        dos.flush();
        dos.close();

        String response = "";
        try {
            response = read(connection.getInputStream());
        } catch (Exception e) {
            response = read(connection.getErrorStream());
        }
        return response;
    }
    
    public String post(String urlStr, Map<String, Object> postArgs) throws IOException, MalformedURLException {
        
    	URL url = new URL(urlStr);
    	
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        connection.setRequestProperty("Accept", DEFAULT_ACCEPT);
        
        connection.setReadTimeout(3000);
        connection.setConnectTimeout(3000);

        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        
        String encodedPostArgs = encodeURLParameters(postArgs);
        
        DataOutputStream dos = new DataOutputStream(connection
                .getOutputStream());
        dos.writeBytes(encodedPostArgs);
        dos.flush();
        dos.close();

        String response = "";
        try {
            response = read(connection.getInputStream());
        } catch (Exception e) {
            response = read(connection.getErrorStream());
        }
        return response;
    }
    
    /**
     * Create URL request [ GET ]
     * @author Jung Min Hyuck (chujinnoon@joycity.com)
     * @param urlStr - request url
     * @param method - request method
     * @return connection response
     */
    
	 public String get(URLTemplate template) throws IOException, MalformedURLException {
    	
    	String urlStr = (template.getParameters() != null ? template.getURL() + "?" + encodeURLParameters(template.getParameters()) : template.getURL());
    	
    	URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       
        String response = "";
        try {
            response = read(connection.getInputStream());
        } catch (Exception e) {
            response = read(connection.getErrorStream());
        }
        return response;
    }
 
    public String get(String urlStr, Map<String, Object> postArgs) throws IOException, MalformedURLException {
    	
    	urlStr = (postArgs != null ? urlStr + "?" + encodeURLParameters(postArgs) : urlStr);
    	URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String response = "";
        try {
            response = read(connection.getInputStream());
        } catch (Exception e) {
            response = read(connection.getErrorStream());
        }
        return response;
    }
    
    private String read(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(in), 1000);
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            sb.append(line);
        }
        in.close();
        return sb.toString();
    }
    
    /**
     * Encodes URL parameters.
     * @author Jung Min Hyuck (chujinnoon@joycity.com)
     * @param params - parameters to be encoded into query string
     * @return parameter string
     */
	
    public static String encodeURLParameters(Map<String, Object> params) throws UnsupportedEncodingException {
        
    	if (params == null) return "";

        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (String key : params.keySet()) {
            if (!isFirst) sb.append('&');
            else isFirst = false;
            sb.append(RFC3986Encoder.encode(key));
            sb.append('=');
            sb.append(RFC3986Encoder.encode(params.get(key).toString()));
        }
        return sb.toString();
    }
    
}
