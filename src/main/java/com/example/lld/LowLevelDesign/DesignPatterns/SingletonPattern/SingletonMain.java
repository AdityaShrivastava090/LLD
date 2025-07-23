package com.example.lld.LowLevelDesign.DesignPatterns.SingletonPattern;

public class SingletonMain {


    public static void main(String[] args) {

        SingletonClass obj =  SingletonClass.getLazyClassObj();
        System.out.println(obj.hashCode());
        SingletonClass obj2 = SingletonClass.getSynchronizedObj();
        System.out.println(obj2.hashCode());

        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        singletonEnum.doPrint();
        System.out.println(singletonEnum.hashCode());
        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;
        System.out.println(singletonEnum2.hashCode());
    }
}
