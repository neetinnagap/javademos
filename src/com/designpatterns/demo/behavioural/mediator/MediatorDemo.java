package com.designpatterns.demo.behavioural.mediator;

public class MediatorDemo {

    public static void main(String args) {

        //Demo without mediator
        Button button = new Button();
        button.press();

        //Demo with mediator
        ButtonWithMediator button2 = new ButtonWithMediator();
        button2.press();

        //Mediator pattern helps in decoupling tightly coupled systems
        //If the connection to the fan is changed to tubelight, the code inside button need not change
        //Only the code inside mediator changes
    }
}
