package com.gnete.springboot.demo.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gnete.springboot.demo.threadpool.callable.HelloCallable;
import com.gnete.springboot.demo.threadpool.runnable.HelloRunnable;

public class TestThreadPool {
	
	private static final Logger logger = LoggerFactory.getLogger(TestThreadPool.class);

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for(int i=0; i<5; i++){
			HelloRunnable command = new HelloRunnable();
			executorService.execute(command);
		}
		
		for(int i=0; i< 5; i++){
			HelloCallable task = new HelloCallable();
			Future<String> future = executorService.submit(task);
			try {
				logger.info(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		executorService.shutdown();//需要手动关闭，不然会一直运行
	}
}
