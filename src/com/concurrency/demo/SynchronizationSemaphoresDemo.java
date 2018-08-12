package com.concurrency.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizationSemaphoresDemo {

    public static void main(String args[]) {

        ExecutorService executor = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(5);
        Runnable task = () -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire();
                if (permit) {
                    System.out.println("Semaphore acquired");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Could'nt acquire semaphore");
                }
            } finally {
                if(permit) {
                    semaphore.release();
                }
            }
        };

        IntStream.range(0, 10).forEach(i -> executor.submit(task));
    }
}
