package com.concurrency.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizationDemo {

    int count = 0;

    void increment() {
        //results in race condition,
        //where more than one thread can increment and store same value of count
        count = count + 1;
    }

    synchronized void incrementSync() {
        //only one thread will increment and store count at a given time
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count = count + 1;
    }

    void doIt() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, 10).forEach(i -> executor.submit(this::incrementSync));
        stop(executor);

        System.out.println(count);
    }

    void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(20, TimeUnit.SECONDS);
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
        new SynchronizationDemo().doIt();
    }
}
