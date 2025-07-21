package com.example.lld.LowLevelDesign.DesignPatterns.ObserverDesignPattern.Observable;

import com.example.lld.LowLevelDesign.DesignPatterns.ObserverDesignPattern.Observer.SubscriberObserver;

public interface ChannelObservable {

    public void addSubScriber(SubscriberObserver subscriberObserver);

    public void removeSubScriber(SubscriberObserver subscriberObserver);

    public void notifySubScriber(String videoTitle);

}
