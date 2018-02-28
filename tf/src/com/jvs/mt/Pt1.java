package com.jvs.mt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pt1 {
	public static void main(String[] args) {
		ExecutorService exs = Executors.newFixedThreadPool(5);
		for(int i=0; i< 10; i++) {
			Runnable worker = new WorkerThread("I'm thread " + i);
			exs.execute(worker);
		}
		exs.shutdown();
		while (exs.isTerminated()) { }
		System.out.println("Finished all threads");
	}
}
