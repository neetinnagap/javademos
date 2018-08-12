package com.concurrency.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorInvokeAnyDemo {

    public static void main(String args[]) {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> tasks = Arrays.asList(
                getCallable("Test1", 2),
                getCallable("Test2", 1),
                getCallable("Test3", 3)
        );
        try {
            //Fastest is returned, one which completes first
            String result = executor.invokeAny(tasks);
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static Callable<String> getCallable(String result, long seconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(seconds);
            return result;
        };
    }
}
