package com.jvs.mt1;

import java.util.concurrent.CountDownLatch;

public class Pt2 {
	public static void main(String[] args) {
		CountDownLatch start = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(4);

		for (int i = 0; i < 5; i++)
			new Thread(new Worker(start, end)).start();

		try {
			System.out.println("main thread doing something");
			Thread.sleep(1000);
			start.countDown();
			System.out.println("main thread doing something else");
			end.await();
		} catch (InterruptedException ie) {
			System.out.println(ie);
		}
	}
}
