package com.gnete.springboot.demo.threadpool.runnable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloRunnable implements Runnable {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloRunnable.class);

	@Override
	public void run() {
		logger.info(Thread.currentThread().getName()+", hello world!");
	}

}
