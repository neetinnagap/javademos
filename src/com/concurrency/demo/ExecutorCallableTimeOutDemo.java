package com.concurrency.demo;

import java.util.concurrent.*;

public class ExecutorCallableTimeOutDemo {

    public static void main(String args[]) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 123;
        };
        Future<Integer> future = executor.submit(task);
        try {
            Integer value = future.get(2, TimeUnit.SECONDS);
            System.out.print(value);
        } catch (InterruptedException e) {
            System.err.print("InterruptedException");
        } catch (ExecutionException e) {
            System.err.print("ExecutionException");
        } catch (TimeoutException e) {
            System.err.print("TimeoutException");
        }
        executor.shutdownNow();
    }
}
