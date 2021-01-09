package com.designpatterns.demo.creational.singleton;

import java.util.Objects;

public class LazySingletonThreadSafe {
    private static LazySingletonThreadSafe INSTANCE;

    private LazySingletonThreadSafe() {}

    public static synchronized LazySingletonThreadSafe getInstance() {
        if(Objects.isNull(INSTANCE)) {
            INSTANCE = new LazySingletonThreadSafe();
        }
        return INSTANCE;
    }
}
