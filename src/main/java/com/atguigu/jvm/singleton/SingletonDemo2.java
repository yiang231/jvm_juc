package com.atguigu.jvm.singleton;

public class SingletonDemo2 {
	/**
	 * 懒汉式
	 */
	private static SingletonDemo2 single;

	private SingletonDemo2() {
	}

	public static synchronized SingletonDemo2 getInstance() {
		if (single == null) {
			single = new SingletonDemo2();
		}
		return single;
	}
}
