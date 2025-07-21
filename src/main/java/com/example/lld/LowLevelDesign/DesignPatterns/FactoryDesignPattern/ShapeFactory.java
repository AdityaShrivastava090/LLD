package com.example.lld.LowLevelDesign.DesignPatterns.FactoryDesignPattern;

public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Triangle();
            case "square":
                return new Square();
            default:
                throw new IllegalArgumentException("Unknown shape: " + shapeType);
        }
    }
}
