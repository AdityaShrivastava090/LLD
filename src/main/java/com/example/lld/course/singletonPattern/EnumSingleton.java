package com.example.lld.course.singletonPattern;

//enums are thread safe
//enums are resistant to reflection attacks
//in java serialization mechanism
enum Singleton
{
    INSTANCE;

    public void doSomething() {
        System.out.println("Hello from Singleton!");
        System.out.println(this.hashCode());
    }
}

public class EnumSingleton {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.INSTANCE;
        singleton1.doSomething();

        Singleton singleton2 = Singleton.INSTANCE;
        singleton2.doSomething();
    }
}
