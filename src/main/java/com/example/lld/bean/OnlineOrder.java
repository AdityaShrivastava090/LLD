package com.example.lld.bean;

import org.apache.catalina.util.ToStringUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("onlineorder")
@Primary
public class OnlineOrder implements Order {

    public OnlineOrder(){
        System.out.println("online order "+ this.hashCode());
    }

}
