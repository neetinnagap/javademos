package com.designpatterns.demo.behavioural.observer.simple;

import java.util.List;

public class Observable {
    private String value;
    private List<Observer> observerList;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        String oldValue = this.value;
        this.value = value;
        this.observerList.forEach(o -> o.propertyChange("value", oldValue, this.value));
    }

    public List<Observer> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }

    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }
}
