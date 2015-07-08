package com.stunstun.spring.mvc.commons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stunstun.spring.mvc.commons.service.SiteConstService;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 11. 19.
 */

@Controller
@RequestMapping(value="/error")
public class ErrorController {

	@RequestMapping("/not_found")
	public String notFountErrorPage(HttpServletRequest req) throws Exception {
		// If you want to log error info, use this method.
		
		return SiteConstService.getSITECONST_SECURE("NOT_FOUND");
	}
}
