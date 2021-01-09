package com.demo;

import com.Child;
import com.Driver;
import com.Engine;
import com.Parent;

import java.io.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Test {
    private int i = 5;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Inside finalize");
    }

    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        t = new Test();
        Thread.sleep(Long.parseLong("50000"));
    }
}
