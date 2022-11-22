package com.atguigu.jvm.heap;

import java.util.ArrayList;
import java.util.Random;

public class Heap_Helloworld {
	byte[] b = new byte[new Random().nextInt(300 * 10240)];

	public static void main(String[] args) {
		ArrayList list = new ArrayList<Heap_Helloworld>();
		while (true) {
			list.add(new Heap_Helloworld());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
