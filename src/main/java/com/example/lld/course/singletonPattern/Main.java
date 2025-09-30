package com.example.lld.course.singletonPattern;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Making first request");
        BasicSingleton singleton1 = BasicSingleton.getInstance();
        singleton1.doSomething();

        System.out.println("Making second request");
        BasicSingleton singleton2 = BasicSingleton.getInstance();
        singleton2.doSomething();
    }
}