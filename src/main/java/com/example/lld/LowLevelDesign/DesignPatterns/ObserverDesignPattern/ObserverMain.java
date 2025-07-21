package com.example.lld.LowLevelDesign.DesignPatterns.ObserverDesignPattern;

import com.example.lld.LowLevelDesign.DesignPatterns.ObserverDesignPattern.Observable.Channel;
import com.example.lld.LowLevelDesign.DesignPatterns.ObserverDesignPattern.Observer.SubScriber;

public class ObserverMain {

    public static void main(String[] args) {
        Channel channel = new Channel("TechWorld");

        SubScriber s1 = new SubScriber("Alice");
        SubScriber s2 = new SubScriber("Bob");
        SubScriber s3 = new SubScriber("Charlie");

        channel.addSubScriber(s1);
        channel.addSubScriber(s2);
        channel.addSubScriber(s3);

        channel.upload("Observer Design Pattern in Java");

        // Unsubscribe one
        channel.removeSubScriber(s2);

        channel.upload("Strategy Design Pattern Explained");
    }
}
