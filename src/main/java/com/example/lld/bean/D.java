package com.example.lld.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class D {


    private final E eObj;

    public D(@Lazy E eObj) {   // <-- Lazy here delays E creation
        System.out.println("D is loading " + this.hashCode());
        this.eObj = eObj;
    }

    public void useE() {
        System.out.println("E is loading from class D " + eObj.hashCode());
    }
}
