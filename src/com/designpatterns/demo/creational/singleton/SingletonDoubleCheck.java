package com.designpatterns.demo.creational.singleton;

import java.util.Objects;

public class SingletonDoubleCheck {

    // Refer: https://www.youtube.com/watch?v=Z5TRputhzHs
    private static volatile SingletonDoubleCheck INSTANCE;

    private SingletonDoubleCheck() {}

    public static SingletonDoubleCheck getInstance() {
        if(Objects.isNull(INSTANCE)) {
            synchronized (SingletonDoubleCheck.class) {
                if(Objects.isNull(INSTANCE)) {
                    INSTANCE = new SingletonDoubleCheck();
                }
            }
        }
        return INSTANCE;
    }
}
