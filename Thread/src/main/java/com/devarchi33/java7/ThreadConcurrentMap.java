package com.devarchi33.java7;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by donghoon on 2015. 12. 29..
 */
public class ThreadConcurrentMap {
    public static void main(String[] args) {
        ThreadConcurrentMap recipe = new ThreadConcurrentMap();
        recipe.start();
    }

    Set<Thread> updateThreads = new HashSet<>();

    private void start() {
        System.out.println(Thread.currentThread().getName() + " is running.");
        ConcurrentMap<Integer, String> concurrentMap = new ConcurrentHashMap<>(); //조회 및 갱신 대상 Map 객체.
        for (int i = 0; i < 10; i++) {
            startUpdateThread(i, concurrentMap); //루프 1회당 스레드 1개씩 총 10개의 스레드가 동일한 concurrentMap 객체를 갱신함.
        }

        try {
            System.out.println(Thread.currentThread().getName() + " is sleep..");
            Thread.sleep(12); //main 스레드 슬립: Map객체의 갱신할 시간을 확보해줌.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Map.Entry<Integer, String> entry : concurrentMap.entrySet()) {
            //메인 스레드에서 갱신중인 concurrentMap 탐색.
            System.out.println("Key :" + entry.getKey() + " Value:" + entry.getValue());
        }

        for (Thread thread : updateThreads) {
            thread.interrupt();
        }
        // goodnight!
    }

    Random random = new Random();

    private void startUpdateThread(int i, final ConcurrentMap<Integer, String> concurrentMap) {
        Thread thread = new Thread(new Runnable() {//호출시 concurrentMap을 갱신하는 스레드 생성.
            public void run() {
                while (!Thread.interrupted()) {
                    int randomInt = random.nextInt(20);
                    concurrentMap.put(randomInt, UUID.randomUUID().toString());
                    System.out.println(Thread.currentThread().getName() + " is running.");
                }
            }
        });
        thread.setName("Update Thread " + i);
        updateThreads.add(thread);
        thread.start();
    }
}
