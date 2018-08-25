package com.gnete.springboot.demo.threadpool.callable;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloCallable implements Callable<String> {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloCallable.class);

	@Override
	public String call() throws Exception {
		logger.info(Thread.currentThread().getName()+", hello callable!");
		return "hello";
	}

}
