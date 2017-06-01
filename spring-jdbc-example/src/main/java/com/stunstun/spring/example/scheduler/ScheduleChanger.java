package com.stunstun.spring.example.scheduler;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author stunstun
 *
 */
@Component
public class ScheduleChanger {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleChanger.class);
	
	@Autowired
	private DynamicSchedule dynamicSchedule;
	
	@Scheduled(fixedDelay = 30000)
	public void change() {
		Random random = new Random();
		int nextTimeout = random.nextInt(30000);
		LOGGER.debug("changing poll time to: " + nextTimeout);
		dynamicSchedule.reset(nextTimeout);
	}
}
