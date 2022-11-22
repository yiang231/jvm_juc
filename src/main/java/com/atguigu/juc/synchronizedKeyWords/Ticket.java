package com.atguigu.juc.synchronizedKeyWords;

public class Ticket {
	private int num = 30;

	public synchronized void saleTicket() {
		if (num <= 0) {
			System.out.println("票已售罄。。。");
			return;
		}
		System.out.println(Thread.currentThread().getName() + "当前正在销售的票号为" + num-- + ",还剩下" + num + "张票");
	}
}
