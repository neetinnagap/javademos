package com.designpatterns.demo;

import javax.management.InstanceNotFoundException;
import java.util.Objects;

public class LazySingleton {

    private static LazySingleton INSTANCE;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if(Objects.isNull(INSTANCE)) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
