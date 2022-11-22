package com.atguigu.juc.thread;

/**
 * 自定义类 实现Runnable接口 重写run方法
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		new Thread(() -> {
			System.out.println("匿名内部类实现定义线程 by Runnable");
		}).start();
	}
}
