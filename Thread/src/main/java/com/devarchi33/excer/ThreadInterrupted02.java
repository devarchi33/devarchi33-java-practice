package com.devarchi33.excer;

public class ThreadInterrupted02 implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		Thread th = new Thread(new ThreadInterrupted02());
		th.start();

		Thread.sleep(50);

		th.interrupt();
	}

	@Override
	public void run() {
		int i = 0;
		while (!Thread.interrupted()) {
			System.out.println("[" + i + "] is running...");
			for (int ii = 0; ii < 1000000; ii++)
				;
			i++;
		}
		System.out.println("terminated.");
	}
}
