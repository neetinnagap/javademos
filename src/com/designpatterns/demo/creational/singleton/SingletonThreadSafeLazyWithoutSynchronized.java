package com.designpatterns.demo.creational.singleton;

public class SingletonThreadSafeLazyWithoutSynchronized {

    //This pattern is called static holder pattern
    private static class Holder {
        private static SingletonThreadSafeLazyWithoutSynchronized INSTANCE = new SingletonThreadSafeLazyWithoutSynchronized();
    }

    public static SingletonThreadSafeLazyWithoutSynchronized getInstance() {
        // Holder class gets lazy loaded by JVM during the following call and is thread safe
        return Holder.INSTANCE;
    }

    private SingletonThreadSafeLazyWithoutSynchronized() {}
}
