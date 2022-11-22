package com.atguigu.juc.thread;

/**
 * 自定义类 实现Runnable接口 重写run方法
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("匿名内部类实现定义线程 by Runnable ");
			}
		});
		thread.start();
	}
}
