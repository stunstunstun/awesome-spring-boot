package com.stunstun.spring.mvc.commons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.stunstun.spring.mvc.commons.service.SiteConstService;

import freemarker.template.SimpleHash;
import freemarker.template.TemplateModelException;


/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */

@Controller
public class BaseController {

	@Autowired
	private SiteConstService siteConstService;
	
	@SuppressWarnings("unused")
	private FreeMarkerConfigurer freemarkerConfig;
	
	/**
	 * Set Freemarker Global Variable
	 */
	
	@Autowired
	public void setFreemarkerConfig(FreeMarkerConfigurer freemarkerConfig) throws TemplateModelException, Exception {
		this.freemarkerConfig = freemarkerConfig;
		SimpleHash hash = new SimpleHash(freemarkerConfig.getConfiguration().getObjectWrapper());
		hash.putAll(siteConstService.getSITECONST_PUBLIC());
		hash.putAll(siteConstService.getSITECONST_SECURE());
		freemarkerConfig.getConfiguration().setAllSharedVariables(hash);
	}
	
}
