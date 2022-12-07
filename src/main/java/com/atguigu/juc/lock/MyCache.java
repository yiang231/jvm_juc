package com.atguigu.juc.lock;

/**
 * 自定义缓存 测试 读写锁
 */
public class MyCache {
	public static void main(String[] args) {
		Cache cache = new Cache();
		for (int i = 0; i < 5; i++) {
			String num = String.valueOf(i);
			new Thread(() -> {
				try {
					cache.set(num, num);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}, "写线程").start();
		}
		for (int i = 0; i < 5; i++) {
			String num = String.valueOf(i);
			new Thread(() -> {
				try {
					cache.get(num);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}, "读线程").start();
		}
	}
}

