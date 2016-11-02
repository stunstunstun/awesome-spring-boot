package com.stunstun.spring.example.scheduler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stunstun.spring.example.support.MonitorService;


/**
 * @author stunstun
 */
@Component
public class DataSourceHealthCheckScheduler {
	private static final Log LOGGER = LogFactory.getLog(DataSourceHealthCheckScheduler.class);
	
	@Autowired
	private MonitorService monitorService;
	
	public void healthCheck() {
		if (monitorService.isEnable()) {
			LOGGER.debug("data source status is alive...");
		}
	}
}
