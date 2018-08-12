package com.concurrency.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorFixedRateDemo {

    public static void main(String args[]) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("After sleeping");
        };

        //Second task is started after fixed period is passed after first task is started
        executor.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);
    }
}
