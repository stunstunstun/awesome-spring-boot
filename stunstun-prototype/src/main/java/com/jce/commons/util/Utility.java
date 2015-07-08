package com.jce.commons.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author Jung Min Hyuck (chujinnoon@joycity.com)
 * @date 2012. 4. 23.
 * @description - HTTP Util
 */

public class Utility {

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
            sb.append(URLEncoder.encode(key, "utf-8"));
            sb.append('=');
            sb.append(URLEncoder.encode(params.get(key).toString(), "utf-8"));
        }
        return sb.toString();
    }
    
    /**
     * Create URL request [ POST ]
     * @author Jung Min Hyuck (chujinnoon@joycity.com)
     * @param urlStr - request url
     * @param method - request method
     * @param postArgs - post parameter for POST request
     * @return connection response
     */
    public static String openUrl(String urlStr, String method, Map<String, Object> postArgs) throws IOException, MalformedURLException {
        
    	URL url = new URL(urlStr);
    	
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", System.getProperties()
                .getProperty("http.agent")
                + " FacebookJavaSDK");
        
        if (!method.equals("GET")) {
            if (!postArgs.containsKey("method")) {
                postArgs.put("method", method);
            }

            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            String encodedPostArgs = encodeURLParameters(postArgs);
            DataOutputStream dos = new DataOutputStream(connection
                    .getOutputStream());
            dos.writeBytes(encodedPostArgs);
            dos.flush();
            dos.close();
        }

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
    
    public static String openUrl(String urlStr, String method) throws IOException, MalformedURLException {
        
    	URL url = new URL(urlStr);
    	
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", System.getProperties()
                .getProperty("http.agent")
                + " FacebookJavaSDK");

        String response = "";
        try {
            response = read(connection.getInputStream());
        } catch (Exception e) {
            response = read(connection.getErrorStream());
        }
        return response;
    }
    
    private static String read(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(in), 1000);
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            sb.append(line);
        }
        in.close();
        return sb.toString();
    }
    
}
