package com.atguigu.juc.coll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();
		CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
//		listError1(arrayList);
		listIterator(arrayList); // 解决办法一
		copyOnWriteArrayList(copyOnWriteArrayList); // 解决办法二
		// java.util.ConcurrentModificationException	并发修改异常 保护集合安全性
	}

	private static void copyOnWriteArrayList(CopyOnWriteArrayList<String> copyOnWriteArrayList) {
		copyOnWriteArrayList.add("1");
		copyOnWriteArrayList.add("2");
		copyOnWriteArrayList.add("3");
		copyOnWriteArrayList.add("4");
		Iterator<String> iterator = copyOnWriteArrayList.iterator();// 使用独有的迭代器
		while (iterator.hasNext()) {
			String next = iterator.next();
			if (next.equals("3"))
				copyOnWriteArrayList.add("yyy");
		}
		copyOnWriteArrayList.forEach(System.out::println);
	}

	private static void listIterator(ArrayList<String> arrayList) {
		arrayList.add("1");
		arrayList.add("2");
		arrayList.add("3");
		ListIterator<String> listIterator = arrayList.listIterator();// 使用独有的迭代器
		while (listIterator.hasNext()) {
			String next = listIterator.next();
			if (next.equals("3"))
				listIterator.add("yyy");
		}
		arrayList.forEach(System.out::println);
	}

	private static void listError1(ArrayList<String> arrayList) {
		for (int i = 0; i < 20; i++) {
			new Thread(() -> {
				arrayList.add(UUID.randomUUID().toString());
				arrayList.forEach(System.out::println);
			}).start();
		}
	}
}
