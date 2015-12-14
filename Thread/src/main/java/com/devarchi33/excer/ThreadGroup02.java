package com.devarchi33.excer;

public class ThreadGroup02 implements Runnable {

	public static void main(String[] args) {
		new Thread(new ThreadGroup02()).start();
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		threadGroup.interrupt();
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("is running...");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
