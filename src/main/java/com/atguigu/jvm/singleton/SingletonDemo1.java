package com.atguigu.jvm.singleton;

public class SingletonDemo1 {
	/**
	 * 饿汉式
	 * 1、构造器私有化
	 * 2、暴露一个获取实例对象的方法
	 */
	private static SingletonDemo1 single = new SingletonDemo1();

	private SingletonDemo1() {
	}

	public static SingletonDemo1 getInstance() {
		return single;
	}
}
