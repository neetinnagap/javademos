package com.designpatterns.demo.behavioural.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NewsAgency {

    PropertyChangeSupport support;
    private String news;

    public NewsAgency() {
        support = new PropertyChangeSupport(this);
    }

    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void updateListeners(String value) {
        support.firePropertyChange("news", this.news, value);
    }
}
