package com.example.lld.LowLevelDesign.DesignPatterns.ObserverDesignPattern.Observer;

public class SubScriber implements SubscriberObserver {
    String name;

    public SubScriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("Hey " + name + " , new video uploaded: " + videoTitle);

    }
}
