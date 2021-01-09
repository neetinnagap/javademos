package com.designpatterns.demo.creational.abstractfactory;

public class AnimalFactory implements AbstractFactory<Animal> {

    @Override
    public Animal create(String name) {
        if(name.equals("Dog")) {
            return new Dog();
        } else {
            return new Duck();
        }
    }
}
