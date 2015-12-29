package com.devarchi33.java7;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by donghoon on 2015. 12. 29..
 */
public class ThreadPutIfAbsent {

    public static void main(String[] args) {
        ThreadPutIfAbsent ia = new ThreadPutIfAbsent();
        ia.start();
    }

    private void start() {
        ConcurrentMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            startUpdateThread(i, concurrentMap); // 새로운 1개의 Map에 키/값을 생성하는 스레드를 루프를 돌며 100개 생성.
        }

        try {
            Thread.sleep(1000);  // 메인 스레드 슬립.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Map.Entry<Integer, String> entry :
                concurrentMap.entrySet()) {  // 생성된 Map의 key/value를 조회.
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    Random random = new Random();

    private void startUpdateThread(int i, final ConcurrentMap<Integer, String> concurrentMap) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() { // 1개의 스레드 안에서 동일한 Map객체에 키/값을 갱신함.
                int randomInt = random.nextInt(20);
                String previouslyEntry = concurrentMap.putIfAbsent(randomInt, "Thread# " + i + " has made it."); // 단, 이미 존재하는 키인지 검사하고 존재하지 않는 키일 때만 추가함.
                if (previouslyEntry != null) {
                    System.out.println("PreviouslyEntry: " + previouslyEntry); // 저장된 키에 해당하는 value를 리턴함.
                    System.out.println("Thread # " + i + " tried to update it but guess what, we're too late!");
                    return;
                } else {
                    System.out.println("Thread # " + i + " has made it.");
                    return;
                }
            }
        });
        thread.start();
    }
}
