package com.bingoogol.axisserver.service;

public class HandlerService {
    public String doHandle(String name) {
        System.out.println("doHandle:" + name);
        return "hello " + name;
    }
}