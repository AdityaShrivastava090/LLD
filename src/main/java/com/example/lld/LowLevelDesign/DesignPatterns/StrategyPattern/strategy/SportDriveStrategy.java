package com.example.lld.LowLevelDesign.DesignPatterns.StrategyPattern.strategy;

public class SportDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Executing Sporty Drive");
    }
}
