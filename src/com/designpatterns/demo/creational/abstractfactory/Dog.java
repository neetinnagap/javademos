package com.designpatterns.demo.creational.abstractfactory;

public class Dog implements Animal {
    @Override
    public String getAnimal() {
        return "Dog";
    }

    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
}
