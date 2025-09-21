package com.example.lld.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class E {

    public E(){
        System.out.println("E is laoding from class e" + this.hashCode());
    }
}
