package com.example.lld.bean;

import org.springframework.stereotype.Component;

@Component
public class C {

    public B b;

    public C(B b){
        this.b = b;
        System.out.println("C is loading  "+ this.hashCode());
        System.out.println("B loaded into C  "+ b.hashCode());
    }
}
