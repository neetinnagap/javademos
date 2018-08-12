package com.concurrency.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutoreInvokeAllDemo {

    public static void main(String args[]) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> tasks = Arrays.asList(
                ()-> "Test 1",
                ()-> "Test 2",
                ()-> "Test 3"
        );
        List<Future<String>> futures = executor.invokeAll(tasks);
        futures.stream().map(future -> {
            String result = "";
            try {
                result = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return result;
        }).forEach(System.out::println);
        //same as, since single method single parameter is used
        //}).forEach(result -> System.out.println(result));
    }
}
