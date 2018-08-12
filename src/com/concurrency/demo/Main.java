package com.concurrency.demo;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String args[]) {

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread: " + threadName);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("After sleep: " + threadName);
        };

        task.run();

        new Thread(task, "New Thread").start();

        System.out.println("Exit");
    }
}
