package com.devarchi33.excer;

public class ThreadDaemon implements Runnable {

	public static void main(String[] args) {
		Thread th = new Thread(new ThreadDaemon());
		th.setDaemon(true);
		th.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main Thread terminated.");
	}

	public void run() {
		while (true) {
			System.out.println("is running...");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
