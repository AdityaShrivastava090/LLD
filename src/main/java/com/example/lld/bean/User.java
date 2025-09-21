package com.example.lld.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Qualifier("offlineorder")
    @Autowired
    Order offlineorder;

    @Qualifier("onlineorder")
    @Autowired
    Order onlineorder;

    public User(Order offorder, Order onorder) {

        this.offlineorder = offorder;
        this.onlineorder = onorder;

        System.out.println("user from constructor : " + this.hashCode());

        System.out.println("offline order from User: " + offlineorder.hashCode());
        System.out.println("online order from User: " + onlineorder.hashCode());
    }

}
