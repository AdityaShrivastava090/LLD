package com.example.lld.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class A {


//    public B b;
//
//    public A(B b){
//        this.b = b;
//        System.out.println("A is loading  "+ this.hashCode());
//        System.out.println("B loaded into A  "+ b.hashCode());
//    }

    public A(){
//        this.b = b;
        System.out.println("A is loading  "+ this.hashCode());
//        System.out.println("B loaded into A  "+ b.hashCode());
    }
}
