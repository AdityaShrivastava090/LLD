package com.example.lld.LowLevelDesign.DesignPatterns.DecoratorDesignPattern.toppings;

import com.example.lld.LowLevelDesign.DesignPatterns.DecoratorDesignPattern.pizza.BasePizza;

public class CheeseTopping implements Topping {

    private final BasePizza basePizza;

    public CheeseTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }


    @Override
    public String getDescription() {
        return basePizza.getDescription() + "Cheese";
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + 50;
    }
}
