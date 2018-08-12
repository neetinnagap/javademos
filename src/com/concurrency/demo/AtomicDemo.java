package com.concurrency.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.concurrency.demo.ConcurrentUtils.stop;

public class AtomicDemo {

    public static void main(String args[]) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        AtomicInteger atomicInt = new AtomicInteger(0);

        IntStream.range(0,1000).forEach(i -> executor.submit(atomicInt::incrementAndGet));
        stop(executor);
        System.out.println(atomicInt.intValue());

        ExecutorService executor2 = Executors.newFixedThreadPool(2);
        AtomicInteger atomicInt2 = new AtomicInteger(0);

        IntStream.range(0,1000).forEach(i -> executor2.submit(() -> atomicInt2.updateAndGet(n -> (n + 2))));
        stop(executor2);
        System.out.println(atomicInt2.intValue());
    }
}
