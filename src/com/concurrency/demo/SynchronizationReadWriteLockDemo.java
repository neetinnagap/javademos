package com.concurrency.demo;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SynchronizationReadWriteLockDemo {

    public static void main(String args[]) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        HashMap<String, String> map = new HashMap<>();

        executor.submit(() -> {
            System.out.println("Got lock");
            lock.writeLock().lock();
            try{
                map.put("foo", "bar");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.writeLock().unlock();
            }
            System.out.println("Released lock");
        });

        Runnable readTask = () -> {
            System.out.println("Inside read");
            lock.readLock().lock();
            try {
                System.out.println(map.get("foo"));
            } finally {
                lock.readLock().unlock();
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);
    }
}
