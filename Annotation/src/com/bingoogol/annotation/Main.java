package com.bingoogol.annotation;

import java.lang.annotation.Inherited;

// java-->class-->运行时
public class Main {

    public static void main(String[] args) {
    }

    // age属性没有指定默认值，使用的时候必须传值
    @MyAnnotation1(age = 23)
    public void testMA1() {

    }

    //如果注解中只有一个属性，并且该属性名为value，则在指定值时可以不用指定属性名
    @MyAnnotation3("dsfs")
    public void testMA3() {

    }
}
