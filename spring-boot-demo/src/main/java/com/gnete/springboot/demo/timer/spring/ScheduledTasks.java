package com.gnete.springboot.demo.timer.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @EnableScheduling: 配置成定时任务
 * @Component：初始化
 * @Configuration：配置类
 * 
 * 在类上加上@EnableScheduling：标注启动定时任务。
 * 在方法加上@Scheduled(fixedRate = 1000 * 30)  定义某个定时任务。
 */
@Component
@Configuration
@EnableScheduling
public class ScheduledTasks {
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	/**
	 * @Scheduled：定义方法为执行，fixedRate=1000*30表示每隔30秒执行一次
	 */
	@Scheduled(fixedRate=1000*30)
	public void reportCurrentTime(){
		logger.info("reportCurrentTime method is trigger, the time is {}", dateFormat().format (new Date ()));
	}
	
	/**
	 * 每1分钟执行一次
	 */
	@Scheduled(cron = "0 */1 *  * * * ")
    public void reportCurrentByCron(){
        logger.info("Scheduling Tasks Examples By Cron: The time is now {}", dateFormat ().format (new Date ()));
    }
	
	private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }
}
