package com.jce.joycity.sample.scheduler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jce.joycity.sample.service.SampleService;

/**
 * @author Jung Min Hyuck(chujinnoon@joycity.com)
 * @date 2012. 6. 11.
 * @description test scheduler
 */

@Component("sampleScheduler")
public class SampleScheduler {
	
	private static final Log logger = LogFactory.getLog(SampleScheduler.class);
	
	@Autowired
	private SampleService sampleService;
	
	public void init() throws Exception {
		
		int num = 1;
		if(sampleService.checkDBConn(num)) logger.info("Scheduler executing now. checkCount is " + sampleService.getCount());
	}
	
}
