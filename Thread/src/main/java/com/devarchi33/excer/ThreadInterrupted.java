package com.devarchi33.excer;

public class ThreadInterrupted implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		Thread th = new Thread(new ThreadInterrupted());
		th.start();

		Thread.sleep(50);

		th.interrupt();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			System.out.println("[" + i + "] is running..."
					+ Thread.interrupted());
			for (int ii = 0; ii < 100000000; ii++)
				;
			i++;
		}
	}
}