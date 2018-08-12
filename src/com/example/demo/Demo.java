package com.example.demo;

public class Demo {

    public static void main(String args[]) {
        MyInterface myInterface = (text) -> {
          System.out.println(text);
        };

        myInterface.print("Hello Lambda");

        Runnable runnable = () -> {
          System.out.println("Inside void run: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.setName("Lambda Thread");
        thread.start();

        try {
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("Exit");
    }
}
