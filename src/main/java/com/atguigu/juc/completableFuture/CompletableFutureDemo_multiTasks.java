package com.atguigu.juc.completableFuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// 多任务组合
public class CompletableFutureDemo_multiTasks {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(121, 423, 2L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4343), new ThreadFactory() {
			int i = 1;

			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setName("核心线程池\t" + i++);
				return thread;
			}
		}, new ThreadPoolExecutor.CallerRunsPolicy());
		CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
			System.out.println(Thread.currentThread().getName() + "\t任务1");
		}, executor);
		System.out.println(Thread.currentThread() + "\tfuture1 = " + future1);
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
//			throw new ArithmeticException();
			System.out.println(Thread.currentThread().getName() + "\t任务2");
			return 123;
		}, executor);
		// 这两条语句所有组合有不同结果
		System.out.println(Thread.currentThread() + "\tfuture2 = " + future2);
		System.out.println(Thread.currentThread() + "\tfuture2 = " + future2.get());
		CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
			System.out.println(Thread.currentThread().getName() + "\t任务3");
		}, executor);
		System.out.println(Thread.currentThread() + "\tfuture3 = " + future3);
		//以上三个异步任务全部完成,做另外一件事,比如保存数据库等操作
		CompletableFuture.allOf(future1, future2, future3)
				.whenCompleteAsync((unused, throwable) -> {
					if (throwable != null) {
						throwable.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "\t" + unused + "\t保数据库");
				}, executor);
		executor.shutdown();
		System.out.println(Thread.currentThread() + "\tmission complete");
		TimeUnit.SECONDS.sleep(3);
	}
}
