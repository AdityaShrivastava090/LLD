package com.example.lld.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class B {


    public C c;
    @Lazy
    public B(C c){
        this.c = c;
        System.out.println("B is loading " + this.hashCode());
    }

}
