package com.concurrency.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationLockExtraDemo {

    void doIt() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ReentrantLock lock = new ReentrantLock();
        executor.submit(() ->{
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });
        executor.submit(() -> {
            System.out.println(lock.isLocked());
            System.out.println(lock.tryLock());
        });

        stop(executor);
    }

    void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
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
        new SynchronizationLockExtraDemo().doIt();
    }
}
