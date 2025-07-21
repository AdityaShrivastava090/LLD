package com.example.lld.LowLevelDesign.DesignPatterns.StrategyPattern.vehicle;

import com.example.lld.LowLevelDesign.DesignPatterns.StrategyPattern.strategy.OffRoadStrategy;

public class OffRoad extends Vehicle {

    public OffRoad() {
        super(new OffRoadStrategy());
    }
}
