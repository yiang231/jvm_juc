package com.atguigu.juc.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
	public static void main(String[] args) {
	/*线程池的优势：线程复用；控制最大并发数；管理线程。
	1. 降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的销耗。
	2. 提高响应速度。当任务到达时，任务可以不需要等待线程创建就能立即执行。
	3. 提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会销耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。*/
//		fixedThreadPool(); // 指定数目线程
//		singleThreadExecutor(); // 单线程
		cachedThreadPool(); // 自己扩张线程
	}

	private static void cachedThreadPool() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool(); // SynchronousQueue
		for (int i = 0; i < 1000000; i++) {
			cachedThreadPool.execute(() -> {
				System.out.println("第\t" + Thread.currentThread().getName() + "\t号线程");
			});
		}
		cachedThreadPool.shutdown();
	}

	private static void singleThreadExecutor() {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(); // LinkedBlockingQueue
		for (int i = 0; i < 10; i++) {
			singleThreadExecutor.execute(() -> {
				System.out.println("第\t" + Thread.currentThread().getName() + "\t号线程");
			});
		}
		singleThreadExecutor.shutdown();
	}

	private static void fixedThreadPool() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);// LinkedBlockingQueue
		for (int i = 0; i < 10000000; i++) {
			fixedThreadPool.execute(() -> {
				System.out.println("第\t" + Thread.currentThread().getName() + "\t号线程");
			});
		}
		fixedThreadPool.shutdown();
	}
}
