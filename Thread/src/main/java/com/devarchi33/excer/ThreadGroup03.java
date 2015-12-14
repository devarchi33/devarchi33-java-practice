package com.devarchi33.excer;

public class ThreadGroup03 implements Runnable {

	public static void main(String[] args) {
		Thread th = new Thread(new ThreadGroup03(), "SampleThread");
		th.start();
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		Thread[] threadArr = new Thread[Thread.activeCount()];
		threadGroup.enumerate(threadArr);

		for (Thread thr : threadArr) {
			System.out.println(thr.getName());
		}

		th.interrupt();
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
