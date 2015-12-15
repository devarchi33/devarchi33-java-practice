package com.devarchi33.excer;

import java.util.ArrayList;

public class ThreadConcurrent03 implements Runnable {

	private ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		ThreadConcurrent03 concurrent = new ThreadConcurrent03();

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
		System.out.println("List Size: " + list.size());
	}

//	private void addList() { //list 객체에 동시접근하는 문제가 발생하므로 실행시마다 list의 size가 바뀜.
	private synchronized void addList() {
		int val = (int) (Math.random() * 10);

		if (!list.contains(val)) {
			list.add(val);
		}

	}
}
