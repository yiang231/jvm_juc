package com.atguigu.juc.synchronizedKeyWords;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {
	private int num = 30;
	// private ReentrantLock reentrantLock = new ReentrantLock(true); // 测试公平性，默认unfair
	private ReentrantLock reentrantLock = new ReentrantLock();

	public void saleTicket() {
		try {
			boolean b = reentrantLock.tryLock(4, TimeUnit.SECONDS); // 限时等待 是否获取到锁
			System.out.println(b);
			if (num <= 0) {
				System.out.println("票已售罄。。。");
				return;
			}
			System.out.println(Thread.currentThread().getName() + "当前正在销售的票号为" + num-- + ",还剩下" + num + "张票");
			check();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			reentrantLock.unlock();
		}
	}

	/**
	 * 测试可重入性
	 */
	private void check() {
		reentrantLock.lock();
		try {
			System.out.println("检查余票。。。");
		} finally {
			reentrantLock.unlock();
		}
	}
}
