package com.example.lld.LowLevelDesign.DesignPatterns.SingletonPattern;

public enum SingletonEnum {

    INSTANCE;

    public void doPrint(){
        System.out.println("Printing........ from enum of sinlgleton");
    }
}
