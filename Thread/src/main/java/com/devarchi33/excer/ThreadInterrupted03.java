package com.devarchi33.excer;

public class ThreadInterrupted03 implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		Thread th = new Thread(new ThreadInterrupted03());
		th.start();

		Thread.sleep(500);
		th.interrupt();
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("is running...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("terminated.");
	}
}
