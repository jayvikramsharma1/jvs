package com.jvs.mt;

public class WorkerThread implements Runnable {
	private final String message;
	
	public WorkerThread(String message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " (start) message = " + message);
		workToBeDone();
		System.out.println(Thread.currentThread().getName() + "(End)");
	}
	
	private void workToBeDone() {
		try {
			System.out.println("Work Done");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
