package com.example.lld.bean;

import org.springframework.stereotype.Component;

@Component("offlineorder")
public class OfflineOrder implements Order{

    public OfflineOrder(){
        System.out.println("offline order  "+ this.hashCode());
    }
}
