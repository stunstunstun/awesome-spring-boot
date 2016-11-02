/**
 * 
 */
package com.stunstun.spring.example.scheduler;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

/**
 * Custom Scheduling in Spring
 * 
 * http://jurberg.github.io/blog/2011/11/05/custom-scheduling-spring/
 * 
 * @author stunstun
 */
public class DynamicSchedule implements Trigger {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DynamicSchedule.class);
	
	private TaskScheduler scheduler;
	
	private Runnable task;
	
	private ScheduledFuture<?> future;
	
	private int delay;
	
	public DynamicSchedule(TaskScheduler scheduler, Runnable task, int delay) {
		this.scheduler = scheduler;
		this.task = task;
		reset(delay);
	}
	
	public void reset(int delay) {
		if (future != null) {
			LOGGER.info("cancelling task...");
			future.cancel(true);
		}
		LOGGER.info("starting task...");
		this.delay = delay;
		future = scheduler.schedule(task, this);
	}

	@Override
	public Date nextExecutionTime(TriggerContext triggerContext) {
		Date lastTime = triggerContext.lastActualExecutionTime();
		Date nextExecutionTime = (lastTime == null) ? new Date() : new Date(lastTime.getTime() + delay);
		LOGGER.info("DynamicSchedule -- delay: " + delay + ", lastActualExecutionTime: " + lastTime	+ "; nextExecutionTime: " + nextExecutionTime);
		return nextExecutionTime;
	}
}
