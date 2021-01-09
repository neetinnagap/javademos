package com.designpatterns.demo.behavioural.mediator;

public class CommonMediator {
    FanWithMediator fan = new FanWithMediator();
    PowerSupply ps = new PowerSupply();

    public void press() {
        fan.turnOn();
    }

    public void supplyPower() {
        ps.supply();
    }
}
