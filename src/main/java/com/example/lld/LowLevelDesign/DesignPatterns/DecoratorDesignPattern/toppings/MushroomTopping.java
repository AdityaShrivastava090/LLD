package com.example.lld.LowLevelDesign.DesignPatterns.DecoratorDesignPattern.toppings;

import com.example.lld.LowLevelDesign.DesignPatterns.DecoratorDesignPattern.pizza.BasePizza;

public class MushroomTopping implements Topping {

    private final BasePizza basePizza;

    public MushroomTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription() + "mushroom";
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + 30;
    }
}
