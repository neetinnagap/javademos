package com.designpatterns.demo.behavioural.observer;

public class ObserverDemo {
    public static void main(String args[]) {
        //Very similar to listeners and events in javascript
        NewsAgency agency = new NewsAgency();
        NewsChannel zeenews = new NewsChannel();
        NewsChannel bbcnews = new NewsChannel();

        agency.addListener(zeenews);
        agency.addListener(bbcnews);
        agency.updateListeners("New news arrived");
    }
}
