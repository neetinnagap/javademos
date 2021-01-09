package com.designpatterns.demo.behavioural.mediator;

public class Button {
    Fan fan = new Fan();

    public void press() {
        fan.turnOn();
    }
}
