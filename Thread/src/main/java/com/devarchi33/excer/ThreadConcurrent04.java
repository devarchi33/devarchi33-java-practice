package com.devarchi33.excer;

import java.util.ArrayList;

public class ThreadConcurrent04 implements Runnable {

	private ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		ThreadConcurrent04 concurrent = new ThreadConcurrent04();
		Thread th1 = new Thread(concurrent);
		Thread th2 = new Thread(concurrent);
		Thread th3 = new Thread(concurrent);

		th1.start();
		th2.start();
		th3.start();
	}

	@Override
	public void run() {
		long sTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			addList();
		}
		long eTime = System.currentTimeMillis();

		System.out.println(Thread.currentThread().getName() + ": "
				+ (eTime - sTime) + "ms");
	}

	public void addList() {
		int val = (int) (Math.random() * 10);

		synchronized (this) {
			list.add(val);
		}
	}
}
