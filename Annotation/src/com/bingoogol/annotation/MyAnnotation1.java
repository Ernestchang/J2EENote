package com.bingoogol.annotation;

import java.lang.annotation.*;
import java.util.List;

//默认值是RetentionPolicy.CLASS，但使用的时候必须手动指定RetentionPolicy.RUNTIME
@Retention(RetentionPolicy.RUNTIME)
//默认是所有值
@Target(ElementType.METHOD)
//指定@Inherited注解后，某个类的子类可以继承父类中的注解
@Inherited
public @interface MyAnnotation1 {
    String name() default "bingoogol";
    int age();
    Gender gender() default Gender.FEMALE;
    Class clazz() default List.class;
    MyAnnotation2 ma2() default  @MyAnnotation2(name = "bingo");
    int[] aa() default 1;
}
