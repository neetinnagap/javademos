package com.designpatterns.demo.behavioural.observer.simple;

public interface Observer {
    void propertyChange(String name, Object oldValue, Object newValue);
}
