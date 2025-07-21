package com.example.lld.LowLevelDesign.DesignPatterns.StrategyPattern.strategy;

public class OffRoadStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println(" Executing OffRoad Drive");
    }
}
