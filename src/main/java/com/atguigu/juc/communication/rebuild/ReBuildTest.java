package com.atguigu.juc.communication.rebuild;

// 使用可重入锁
public class ReBuildTest {
	private static final ReBuildResource rebuild = new ReBuildResource();

	public static void main(String[] args) {
		print("Q");
		print("W");
		print("E");
		print("R");
	}

	public static void print(String str) {
		new Thread(() -> {
			for (int i = 0; i < 50; i++) {
				rebuild.printStr(str);
			}
		}).start();
	}
}
