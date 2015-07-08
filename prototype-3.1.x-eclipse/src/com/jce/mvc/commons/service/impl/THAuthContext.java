package com.jce.mvc.commons.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.jce.lib.util.CookieUtil;
import com.jce.mvc.commons.service.AuthContext;
import com.jce.mvc.commons.service.SiteConstService;
import com.jce.mvc.commons.session.LoginSession;
import com.jce.mvc.commons.session.MakeLoginSessionException;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */

@Service("thAuthContext")
public class THAuthContext implements AuthContext {

	public LoginSession getLoginSession(HttpServletRequest request, HttpServletResponse response) throws MakeLoginSessionException, Exception {
		
		String THCookies = CookieUtil.getCookieValue(request, "JS_THCookies", SiteConstService.getSITECONST_SECURE("CRYPTOKEY"));
		LoginSession loginSession = new LoginSession();
		if(THCookies == null) return loginSession;
		
		// Set TH Cookie
		String arrCookie[] = null;
		String arrCookieEle[] = new String[10];
		String arrTemp[] = new String[2];
		
		try {
			arrCookie = THCookies.split(",");
			for (int i = 0; i < arrCookie.length; i++) {
				arrTemp = arrCookie[i].split("=");
				arrCookieEle[i] = (arrTemp.length > 1) ? arrTemp[1] : null;
			}
		} catch(Exception e) {
			throw new MakeLoginSessionException("Cause error, make LoginSession");
		}
		
		/**
		[TH Cookie Info]
		arrCookieEle[0] -> JS_SessionGUID = SessionGUID
		arrCookieEle[1] -> JS_UserIDIndex = UserIDIndex
		arrCookieEle[2] -> JS_UserID = UserID
		arrCookieEle[3] -> JS_EMail = EMail
		arrCookieEle[4] -> JS_Cash = Cash
		arrCookieEle[5] -> JS_Sex = sex
		arrCookieEle[6] -> JS_CertStatus = CertStatus
		arrCookieEle[7] -> JS_ExpID = ExpID
		arrCookieEle[8] -> JS_ExpIDRegDate = ExpID RegDate
		arrCookieEle[9] -> JS_Join = Y/null
		**/
		
		if(arrCookieEle[0] == null) throw new MakeLoginSessionException("Cause error, make LoginSession: arrCookieEle[] is null.");
				
		loginSession.setLogin(true);
		loginSession.setSessionGUID(arrCookieEle[0]);
		loginSession.setUserIdIndex(Integer.parseInt(arrCookieEle[1]));
		loginSession.setUserId(arrCookieEle[2]);
		loginSession.setEmail(arrCookieEle[3]);
		loginSession.setCash(loginSession.getUserCash(arrCookieEle[4], Integer.parseInt(SiteConstService.getSITECONST_PUBLIC("SITE_CODE"))));
		loginSession.setSex(arrCookieEle[5]);
		
		return loginSession;
	}
}
