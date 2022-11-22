package com.atguigu.jvm.singleton;

public class Test {
	public static void main(String[] args) {

		SingletonDemo1 singletonDemo1 = SingletonDemo1.getInstance();
		System.out.println("singletonDemo1 = " + singletonDemo1);
		SingletonDemo1 singletonDemo11 = SingletonDemo1.getInstance();
		System.out.println("singletonDemo11 = " + singletonDemo11);
		SingletonDemo1 singletonDemo12 = SingletonDemo1.getInstance();
		System.out.println("singletonDemo12 = " + singletonDemo12);

		SingletonDemo2 singletonDemo2 = SingletonDemo2.getInstance();
		System.out.println("singletonDemo2 = " + singletonDemo2);
		SingletonDemo2 singletonDemo21 = SingletonDemo2.getInstance();
		System.out.println("singletonDemo21 = " + singletonDemo21);
		SingletonDemo2 singletonDemo22 = SingletonDemo2.getInstance();
		System.out.println("singletonDemo22 = " + singletonDemo22);
	}
}
