package com.jce.mvc.commons.interceptor.support;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MinHyuck Jung(chujinnoon@joycity.com)
 * @date 2013. 2. 8.
 */

public class TrafficManager {

	private Vector<String[]> _vector;
	  
	private TrafficManager() {
		_vector = new Vector<String[]>();
	}

	private static final class TrafficManagerHolder {
		public static final TrafficManager instance = new TrafficManager(); 
	}

	public static TrafficManager getInstance() {
		return TrafficManagerHolder.instance;
	}

	public boolean checkTraffic(HttpServletRequest request, int filterCnt, int maxSize) throws Exception {
		
		boolean result = false;
		int matchedCnt = 0;
		
		String ip = request.getRemoteAddr();
		String url = request.getRequestURI();
		url = ((request.getQueryString() == null) ? url : url + "?" + request.getQueryString());
		
		String[] requestUrlInfo = {ip, url};
		synchronized (this) {
			_vector.addElement(requestUrlInfo);
			if (_vector.size() > maxSize) _vector.removeElementAt(0);
			for (int i = 0, length = _vector.size() ; i < length ; i++) {
				String[] outstr = (String[]) _vector.elementAt(i);
				if ((outstr[0].equals(ip)) && (outstr[1].equals(url))) matchedCnt++;
				if (matchedCnt > filterCnt) return true;
			}
		}
		return result;
	}
}
