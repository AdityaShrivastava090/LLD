package com.example.lld.LowLevelDesign.DesignPatterns.DecoratorDesignPattern.pizza;

public class ThinCrust implements BasePizza{
    @Override
    public String getDescription() {
        return "THis is a thin crust pizza with";
    }

    @Override
    public int getCost() {
        return 130;
    }
}
