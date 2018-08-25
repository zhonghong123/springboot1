package com.gnete.springboot.demo.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.gnete.springboot.demo.threadpool.runnable.HelloRunnable;

/**
 * 自定义线程池，一般编程用这种自定义的线程池
 * 
 * @author hong
 *
 */
public class TestThreadPoolExecutor {

	public static void main(String[] args) {
		BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, workQueue);
		for(int i = 0; i<10; i++){
			executor.execute(new HelloRunnable());
		}
		
		executor.shutdown();//如果需要关闭线程池，需要手动关闭
	}
}
