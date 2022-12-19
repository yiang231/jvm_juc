package com.atguigu.juc.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

// 阻塞队列
// 1、ArrayBlockingQueue 有界阻塞队列，数组，查询快，增删慢，空间浪费
// 2、LinkedBlockingQueue 有界阻塞队列，链表，查询慢，增删快，可以使用空间碎片，不指定长度会内存溢出
// 3、SynchronousQueue 队列中只有一个元素，效率低下
public class BlockingQueueDemo {
	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
		LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(5);// 默认Integer.MAX_VALUE

//		add(arrayBlockingQueue);
//		remove(arrayBlockingQueue);
//		element(arrayBlockingQueue);

//		offer(arrayBlockingQueue);
//		poll(arrayBlockingQueue);
//		peek(arrayBlockingQueue);

//		put(arrayBlockingQueue);
//		take(arrayBlockingQueue);

		System.out.println(arrayBlockingQueue);
		System.out.println(linkedBlockingQueue);
	}

	private static void take(ArrayBlockingQueue<String> arrayBlockingQueue) throws InterruptedException {
//		arrayBlockingQueue.put("a");
//		arrayBlockingQueue.put("b");
//		arrayBlockingQueue.put("c");
//		arrayBlockingQueue.put("d");
		arrayBlockingQueue.put("e");
		arrayBlockingQueue.take();
		TimeUnit.SECONDS.sleep(3);
		arrayBlockingQueue.put("f");
	}

	private static void put(ArrayBlockingQueue<String> arrayBlockingQueue) throws InterruptedException {
		arrayBlockingQueue.put("a");
		arrayBlockingQueue.put("b");
		arrayBlockingQueue.put("c");
		arrayBlockingQueue.put("d");
		arrayBlockingQueue.put("e");
		arrayBlockingQueue.put("g");
	}

	private static void peek(ArrayBlockingQueue<String> arrayBlockingQueue) {
//		arrayBlockingQueue.offer("a");
//		arrayBlockingQueue.offer("b");
//		arrayBlockingQueue.offer("c");
//		arrayBlockingQueue.offer("d");
		System.out.println(arrayBlockingQueue.peek());
	}

	private static void poll(ArrayBlockingQueue<String> arrayBlockingQueue) {
//		arrayBlockingQueue.offer("a");
//		arrayBlockingQueue.offer("b");
//		arrayBlockingQueue.offer("c");
//		arrayBlockingQueue.offer("d");
//		System.out.println(arrayBlockingQueue.offer("e"));
		System.out.println(arrayBlockingQueue.poll()); // 第一个元素
	}

	private static void offer(ArrayBlockingQueue<String> arrayBlockingQueue) {
		arrayBlockingQueue.offer("a");
		arrayBlockingQueue.offer("b");
		arrayBlockingQueue.offer("c");
		arrayBlockingQueue.offer("d");
		System.out.println(arrayBlockingQueue.offer("e"));
		System.out.println(arrayBlockingQueue.offer("f"));
	}

	private static void element(ArrayBlockingQueue<String> arrayBlockingQueue) {
		arrayBlockingQueue.add("a");
		arrayBlockingQueue.add("b");
		arrayBlockingQueue.add("c");
		arrayBlockingQueue.add("d");
		System.out.println(arrayBlockingQueue.element());
	}

	private static void remove(ArrayBlockingQueue<String> arrayBlockingQueue) {
		arrayBlockingQueue.remove();
//		arrayBlockingQueue.remove("a");
	}

	private static void add(ArrayBlockingQueue<String> arrayBlockingQueue) {
		arrayBlockingQueue.add("a");
		arrayBlockingQueue.add("b");
		arrayBlockingQueue.add("c");
		arrayBlockingQueue.add("d");
		System.out.println(arrayBlockingQueue.add("e"));
//		arrayBlockingQueue.add("f");
	}
}
