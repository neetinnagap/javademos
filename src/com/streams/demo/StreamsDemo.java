package com.streams.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsDemo {

    private final int[] numbers = {9, 5, 7, 3, 1, 4, 0};

    private final List<Shape> shapes = new ArrayList<Shape>() {{
        add(new Shape(1, 3, "blue"));
        add(new Shape(4, 4, "orange"));
        add(new Shape(3, 6, "blue"));
        add(new Shape(5, 3, "red"));
        add(new Shape(6, 4, "yellow"));
        add(new Shape(2, 5, "green"));
        add(new Shape(7, 6, "blue"));
    }};
    
    /**
     * A regular and most common min calculation
     */
    private void regularMinDemo() {
        int min = numbers[0];
        for(int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) min = numbers[i];
        }
        System.out.println(min);
    }

    /**
     * With streams demo1 can be done as follows
     */
    private void streamsMinDemo() {
        IntStream.of(numbers).min().ifPresent(System.out::println);
        IntStream.of(numbers).max().ifPresent(System.out::println);
        IntStream.of(numbers).average().ifPresent(System.out::println);
        System.out.println(IntStream.of(numbers).count());
        System.out.println(IntStream.of(numbers).sum());
    }

    /**
     * Optimizing creation of IntStream in the above method
     */
    private void streamsMinDemoOptimized() {
        IntSummaryStatistics stats = IntStream.of(numbers).summaryStatistics();
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
    }

    /**
     * Regular way to get distinct least 3 numbers
     */
    private void regularMin3Demo() {
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(copy);
        for(int i = 0; i < 3; i++) {
            System.out.println(copy[i]);
        }
    }

    private void streamsMin3Demo() {
        IntStream.of(numbers).distinct().sorted().limit(3).forEach(System.out::println);
    }

    private void streamsWitObjects() {
        System.out.println("Are there any shapes with color orange? : " + shapes.stream().anyMatch((shape) -> shape.getColor().equals("orange")));
        System.out.println("Are all shapes valid? (vertices > 2) : " + shapes.stream().allMatch((shape) -> shape.getVertices() > 2));
    }

    private void collectedStreams() {
        shapes.stream()
                .filter((shape) -> shape.getVertices() > 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private void collectedSortedStreams() {
        shapes.stream()
                .sorted(Comparator.comparingInt(Shape::getVertices).reversed())
                .map(Shape::getVertices)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        StreamsDemo demo = new StreamsDemo();
//        demo.regularMinDemo();
//        demo.streamsMinDemo();
//        demo.streamsMinDemoOptimized();
        demo.regularMin3Demo();
//        demo.streamsMin3Demo();
//        demo.streamsWitObjects();
//        demo.collectedStreams();
//        demo.collectedSortedStreams();
    }
}
