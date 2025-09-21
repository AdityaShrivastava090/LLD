package com.example.lld.LowLevelDesign.DesignPatterns.DecoratorDesignPattern.pizza;

public class Marghreita implements BasePizza{


    @Override
    public String getDescription() {
        return " Marghreita Pizza with";
    }

    @Override
    public int getCost() {
        return 100;
    }
}
