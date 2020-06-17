package com.streams.demo;

public class Shape {
    private int weight;
    private int vertices;
    private String color;

    public Shape(int weight, int vertices, String color) {
        this.weight = weight;
        this.vertices = vertices;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public int getVertices() {
        return vertices;
    }

    public String getColor() {
        return color;
    }
}
