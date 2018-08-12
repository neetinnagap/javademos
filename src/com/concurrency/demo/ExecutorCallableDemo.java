package com.concurrency.demo;

import java.util.concurrent.*;

public class ExecutorCallableDemo {

    public static void main(String args[]){
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Callable<Integer> task = () -> {
            System.out.println("Inside callable");
            TimeUnit.SECONDS.sleep(5);
            return 1;
        };
        Future<Integer> future = executor.submit(task);

        System.out.println("is done: " + future.isDone());

        try {
            Integer value = future.get();
            System.out.println(value);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("is done: " + future.isDone());

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
