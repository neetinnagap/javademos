package com.designpatterns.demo;

public class SingletonDemo {
    public static void main(String args[]) {
        EagerSingleton es = EagerSingleton.getInstance();
        System.out.println(es.hashCode());

        EagerSingleton es2 = EagerSingleton.getInstance();
        System.out.println(es2.hashCode());

        LazySingleton ls = LazySingleton.getInstance();
        System.out.println(ls.hashCode());

        LazySingleton ls2 = LazySingleton.getInstance();
        System.out.println(ls2.hashCode());
    }
}
