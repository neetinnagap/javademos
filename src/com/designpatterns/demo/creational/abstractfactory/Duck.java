package com.designpatterns.demo.creational.abstractfactory;

public class Duck implements Animal {
    @Override
    public String getAnimal() {
        return "Duck";
    }

    @Override
    public void makeSound() {
        System.out.print("Quak!");
    }
}
