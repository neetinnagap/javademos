package com.designpatterns.demo;

public class BuilderPatternDemo {

    public static void main(String args[]) {
        Student.StudentBuilder studentBuilder = Student.StudentBuilder.getInstance();
        Student student = studentBuilder.setId(1).setName("Neetin").setAddress("Mumbai").build();
    }
}
