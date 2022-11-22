package com.atguigu.juc.thread;

public class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("myThread by extends Thread");
	}
}
