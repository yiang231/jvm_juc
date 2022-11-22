package com.atguigu.juc.synchronizedKeyWords;

// 在main方法中创建多线程方法，测试卖票业务
public class SaleTicket {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		new Thread(() -> {
			for (int i = 0; i < 30; i++) {
				ticket.saleTicket();
			}
		}, "窗口1").start();
		new Thread(() -> {
			for (int i = 0; i < 30; i++) {
				ticket.saleTicket();
			}
		}, "窗口2").start();
		new Thread(() -> {
			for (int i = 0; i < 30; i++) {
				ticket.saleTicket();
			}
		}, "窗口3").start();
	}
}
