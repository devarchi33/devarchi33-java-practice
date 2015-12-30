package com.devarchi33.java7;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by donghoon on 2015. 12. 30..
 * <p>
 * 문제: 개별 스레드에 작업을 나눠줘서 CPU 자원 사용률을 최대로 끌어올리고 싶다.
 */
public class ThreadPoolExcutorExam {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExcutorExam te = new ThreadPoolExcutorExam();
        te.start();
    }

    private void start() throws InterruptedException {
        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();
        for (int i = 0; i < 10; i++) {
            final int localI = i;
            queue.add(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(localI);
                }
            });
        }

        ThreadPoolExecutor excutor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.MILLISECONDS, queue);
        excutor.prestartAllCoreThreads();
        excutor.shutdown();
        excutor.awaitTermination(10000, TimeUnit.SECONDS);
        System.out.println("All operations were completed.");
    }

    private void doExpensiveOperation(int index) {
        System.out.println("Start Expensive operation " + index);
        try {
            Thread.sleep(index * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending expensive operation " + index);
    }
}
