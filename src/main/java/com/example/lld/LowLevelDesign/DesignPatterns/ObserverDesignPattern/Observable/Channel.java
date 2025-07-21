package com.example.lld.LowLevelDesign.DesignPatterns.ObserverDesignPattern.Observable;

import com.example.lld.LowLevelDesign.DesignPatterns.ObserverDesignPattern.Observer.SubscriberObserver;

import java.util.ArrayList;
import java.util.List;

public class Channel implements ChannelObservable {

    public List<SubscriberObserver> subScriberList = new ArrayList<>();
    private String channelName;

    public Channel(String channelName){
        this.channelName = channelName;
    }

    @Override
    public void addSubScriber(SubscriberObserver subscriberObserver) {
        subScriberList.add(subscriberObserver);
    }

    @Override
    public void removeSubScriber(SubscriberObserver subscriberObserver) {
        subScriberList.remove(subscriberObserver);
    }

    @Override
    public void notifySubScriber(String videoTitle) {
        for (SubscriberObserver sub : subScriberList) {
            sub.update(videoTitle);
        }
    }


    public void upload(String videoTitle){
        System.out.println("Channel: " + channelName + " uploaded a new video: " + videoTitle);
        notifySubScriber(videoTitle);
    }
}
