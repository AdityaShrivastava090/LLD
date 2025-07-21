package com.example.lld.LowLevelDesign.DesignPatterns.StrategyPattern.strategy;

public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Executing Normal Drive");
    }
}
