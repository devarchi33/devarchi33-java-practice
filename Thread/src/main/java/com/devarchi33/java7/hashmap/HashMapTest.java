package com.devarchi33.java7.hashmap;

import java.util.*;

/**
 * Created by donghoon on 2015. 12. 30..
 */
public class HashMapTest {

    public static void initData(Map<String, Integer> map) {
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        map.put("key4", 4);
        map.put("key5", 5);
        map.put("key6", 6);
        map.put("key7", 7);
        map.put("key8", 8);
        map.put("key9", 9);
        map.put("key10", 10);
    }

    public static void printResult(Map<String, Integer> map) {
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer value = map.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }

    public static void main(String[] args) {
        System.out.println("========== HashMap Test ==========");
        Map<String, Integer> hashMap = new HashMap<>();
        initData(hashMap);
        printResult(hashMap);

        System.out.println("========== LinkedHashMap Test ==========");  //순서를 보장하는 해쉬 맵.
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        initData(linkedHashMap);
        printResult(linkedHashMap);
    }
}
