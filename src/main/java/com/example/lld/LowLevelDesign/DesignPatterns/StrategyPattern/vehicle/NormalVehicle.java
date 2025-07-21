package com.example.lld.LowLevelDesign.DesignPatterns.StrategyPattern.vehicle;

import com.example.lld.LowLevelDesign.DesignPatterns.StrategyPattern.strategy.NormalDriveStrategy;

public class NormalVehicle extends Vehicle {

    public NormalVehicle() {
        super(new NormalDriveStrategy());
    }
}
