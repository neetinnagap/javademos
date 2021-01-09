package com.designpatterns.demo.behavioural.mediator;

public class ButtonWithMediator {
    CommonMediator mediator = new CommonMediator();

    public void press() {
        mediator.press();
    }
}
