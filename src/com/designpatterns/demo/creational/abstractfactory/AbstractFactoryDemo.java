package com.designpatterns.demo.creational.abstractfactory;

public class AbstractFactoryDemo {
    public static void main(String args[]) {
        AnimalFactory factory = new AnimalFactory();
        Animal animal = factory.create("Dog");
        System.out.println(animal.getAnimal());
        animal.makeSound();
    }
}
