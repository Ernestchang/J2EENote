package com.bingoogol.axisserver.service;

public class HelloWorldService {
    public String sayHello(String name) {
        System.out.println("sayHello:" + name);
        return "hello " + name;
    }

    public String sayHehe(String name) {
        System.out.println("sayHehe:" + name);
        return "hehe " + name;
    }

    private String testPrivate() {
        System.out.println("testPrivate" );
        return "private";
    }
}