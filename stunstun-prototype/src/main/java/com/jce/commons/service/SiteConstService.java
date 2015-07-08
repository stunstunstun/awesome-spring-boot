
package com.jce.commons.service;

import java.util.Map;


public class SiteConstService {
	
	private static Map<String, String> SITECONST_PUBLIC = null;
	private static Map<String, String> SITECONST_SECURE = null;

	public Map<String, String> getSITECONST_PUBLIC() {
		return SITECONST_PUBLIC;
	}

	public void setSITECONST_PUBLIC(Map<String, String> siteconst_public) {
		SITECONST_PUBLIC = siteconst_public;
	}

	public Map<String, String> getSITECONST_SECURE() {
		return SITECONST_SECURE;
	}

	public void setSITECONST_SECURE(Map<String, String> siteconst_secure) {
		SITECONST_SECURE = siteconst_secure;
	}

	public static String getSITECONST_PUBLIC(String pam0) {
		return SITECONST_PUBLIC.get(pam0);
	}

	public static String getSITECONST_SECURE(String pam0) {
		return SITECONST_SECURE.get(pam0);
	}
}
