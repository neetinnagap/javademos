package com.concurrency.demo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class ConcurrentMapDemo {

    public static void main(String args[]) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("one", "I");
        map.put("two", "II");
        map.put("three", "III");
        map.put("four", "IV");
        map.put("five", "V");

        print(map);

        map.putIfAbsent("six", "VI");
        print(map);

    }

    static private void print(ConcurrentMap<String, String> map) {
        System.out.println("Printing...");
        map.forEach((key, value) -> System.out.println(key +":"+value));
    }
}
