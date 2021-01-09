package com;

import com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_zh_CN;

import java.io.Serializable;

public class Engine implements Serializable {
    private String name;
    private Driver driver;

    public Engine(){}

    public Engine(String name, Driver driver) {
        this.name = name;
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public Driver getDriver() {
        return driver;
    }

}
