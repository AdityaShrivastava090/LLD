package com.example.lld.LowLevelDesign.DesignPatterns.FactoryDesignPattern;

public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();  // Output: Drawing a Circle.

        Shape shape2 = shapeFactory.getShape("rectangle");
        shape2.draw();  // Output: Drawing a Rectangle.

        Shape shape3 = shapeFactory.getShape("square");
        shape3.draw();  // Output: Drawing a Square.
    }
}
