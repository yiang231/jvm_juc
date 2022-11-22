package com.atguigu.juc.thread;

public class ThreadLocalDemo {
	public static void main(String[] args) {
		ThreadLocal<Object> threadLocal = new ThreadLocal<>();
		threadLocal.set(1);
		System.out.println("threadLocal.get() = " + threadLocal.get());

		MyThread myThread = new MyThread();
		myThread.start();
	}
}
