package com.designpatterns.demo.behavioural.observer.simple;

public class PropertyObserver implements Observer {
    @Override
    public void propertyChange(String name, Object oldValue, Object newValue) {
        System.out.println("Property changed: "+ newValue.toString());
    }
}
