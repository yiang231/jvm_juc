package com.atguigu.juc.communication;

// 线程有序通信
public class CommunicationThread2 {
	public static void main(String[] args) {
		MyResource2 myResource2 = new MyResource2();
		new Thread(() -> {
			try {
				myResource2.printA5();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				myResource2.printB10();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				myResource2.printC15();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}

