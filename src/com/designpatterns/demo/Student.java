package com.designpatterns.demo;

public final class Student {

    private int id;
    private String name;
    private String address;

    public Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
    }

    public static class StudentBuilder {
        private int id;
        private String name;
        private String address;

        private StudentBuilder() {}

        public static StudentBuilder getInstance() {
            return new StudentBuilder();
        }

        public StudentBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
