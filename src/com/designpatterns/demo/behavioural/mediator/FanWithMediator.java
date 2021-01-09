package com.designpatterns.demo.behavioural.mediator;

public class FanWithMediator {
    CommonMediator mediator = new CommonMediator();

    public void turnOn() {
        mediator.supplyPower();
    }
}
