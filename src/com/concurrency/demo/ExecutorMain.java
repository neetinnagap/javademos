package com.concurrency.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorMain {

    public static void main(String args[]) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(()->{
            System.out.println("Inside task");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch(InterruptedException e) {
                System.err.println("Task " + Thread.currentThread().getName() + " interrupted");
            }
            System.out.println("Exiting thread");
        });

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
}
