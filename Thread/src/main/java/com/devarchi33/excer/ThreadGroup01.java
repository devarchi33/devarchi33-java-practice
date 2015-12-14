package com.devarchi33.excer;

public class ThreadGroup01 implements Runnable {

	public static void main(String[] args) {
		Thread th = new Thread(new ThreadGroup01());
		Thread.currentThread().getThreadGroup()
				.setMaxPriority(Thread.MIN_PRIORITY); // priority: 1.
		th.setPriority(Thread.MAX_PRIORITY);
		th.start();
	}

	public void run() {
		System.out.println("Priority: " + Thread.currentThread().getPriority());
	}

}
