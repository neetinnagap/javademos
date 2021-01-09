package com.designpatterns.demo.creational.abstractfactory;

public interface AbstractFactory<T> {
    T create(String name);
}
