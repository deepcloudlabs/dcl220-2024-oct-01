package com.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class BridgePatternThreadPool {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Application is just started.");
		ExecutorService es = Executors.newFixedThreadPool(10);
		Future<Integer> result = es.submit(() -> {
			TimeUnit.SECONDS.sleep(5);
			return 42;
		});	
		System.out.println(result.get());
		es.shutdown();
		System.out.println("Application is stoped.");
		// ExecutorService -----> Future
		//     submit               get
	}

}
