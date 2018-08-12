package com.concurrency.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class SynchronizationLockDemo {

    int count = 0;
    ReentrantLock lock = new ReentrantLock();

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    void doIt() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, 10000).forEach(i -> executor.submit(this::increment));
        stop(executor);

        System.out.print(count);
    }

    void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }catch (InterruptedException e) {
            System.err.println("Tasks interrupted");
        } finally {
            if(!executor.isTerminated()) {
                System.err.println("cancel non finished tasks");
            }
            executor.shutdownNow();
            System.out.println("Executor terminated");
        }
    }

    public static void main(String args[]) {
        new SynchronizationLockDemo().doIt();

    }
}
