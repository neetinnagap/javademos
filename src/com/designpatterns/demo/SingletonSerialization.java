package com.designpatterns.demo;

import java.io.Serializable;
import java.util.Objects;

public class SingletonSerialization implements Serializable {
    //This class prevents new instace to be created from serialized objects
    private static SingletonSerialization INSTANCE;

    private SingletonSerialization() {}

    public static SingletonSerialization getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new SingletonSerialization();
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
