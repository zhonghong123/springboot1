package com.gnete.springboot.demo.timer.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component(value="scheduledTasks2")
@EnableScheduling
public class ScheduledTasks {
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	public void reportCurrentByCron(){
		logger.info("reportCurrentByCron trigger 666666");
	}
}
