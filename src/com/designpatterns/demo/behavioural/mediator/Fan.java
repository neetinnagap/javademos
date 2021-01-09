package com.designpatterns.demo.behavioural.mediator;

public class Fan {
    PowerSupply ps = new PowerSupply();

    public void turnOn() {
        ps.supply();
    }
}
