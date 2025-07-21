package com.example.lld.LowLevelDesign.DesignPatterns.StrategyPattern.vehicle;

import com.example.lld.LowLevelDesign.DesignPatterns.StrategyPattern.strategy.SportDriveStrategy;

public class SportyVehicle extends Vehicle {

    public SportyVehicle() {
        super(new SportDriveStrategy());
    }
}
