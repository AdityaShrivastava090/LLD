package com.example.lld.LowLevelDesign.DesignPatterns.DecoratorDesignPattern;

import com.example.lld.LowLevelDesign.DesignPatterns.DecoratorDesignPattern.pizza.BasePizza;
import com.example.lld.LowLevelDesign.DesignPatterns.DecoratorDesignPattern.pizza.Marghreita;
import com.example.lld.LowLevelDesign.DesignPatterns.DecoratorDesignPattern.pizza.ThinCrust;
import com.example.lld.LowLevelDesign.DesignPatterns.DecoratorDesignPattern.toppings.CheeseTopping;
import com.example.lld.LowLevelDesign.DesignPatterns.DecoratorDesignPattern.toppings.MushroomTopping;

public class DecoratorMain {

    public static void main(String[] args) {
        // Base Pizza
        BasePizza pizza = new Marghreita();
        System.out.println(pizza.getDescription() + " -> Rs." + pizza.getCost());

        // Add Cheese
        pizza = new CheeseTopping(pizza);
        System.out.println(pizza.getDescription() + " -> Rs." + pizza.getCost());

        // Add Mushroom
        pizza = new MushroomTopping(pizza);
        System.out.println(pizza.getDescription() + " -> Rs." + pizza.getCost());

        // Another Example: Farmhouse + Cheese
        BasePizza pizza2 = new ThinCrust();
        pizza2 = new CheeseTopping(pizza2);
        System.out.println(pizza2.getDescription() + " -> Rs." + pizza2.getCost());
    }
}

