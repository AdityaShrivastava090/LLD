package com.example.lld.LowLevelDesign.DesignPatterns.StrategyPattern;

import com.example.lld.LowLevelDesign.DesignPatterns.StrategyPattern.vehicle.SportyVehicle;
import com.example.lld.LowLevelDesign.DesignPatterns.StrategyPattern.vehicle.Vehicle;

public class StrategyMain {

    public static void main(String[] args) {
        Vehicle vehicle = new SportyVehicle();
        vehicle.drive();
    }
}
