package com.atguigu.juc.volatileKeyWord;

public class Resource {
	volatile int num = 0; // 不保证原子性

	public synchronized Integer addPlus() {
//	public Integer addPlus() {
		return ++num;
	}
}
