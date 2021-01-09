package com.designpatterns.demo.creational.singleton;

import java.util.Objects;

public class SingletonReflection {
    //This class provides protection from reflection

    private static SingletonReflection INSTANCE;

    private SingletonReflection() {
        if(Objects.nonNull(INSTANCE)) {
            throw new RuntimeException("Object of single ton class should be created using getInstance()");
        }
    }

    public static SingletonReflection getInstance() {
        if(Objects.isNull(INSTANCE)) {
            INSTANCE = new SingletonReflection();
        }
        return INSTANCE;
    }
}
