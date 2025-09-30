package com.example.lld.course.BuilderPattern;

public class LegacyConstructorExample {



}

//Hard to extend or maintain
//Validations can be hard
//Overloaded Constructors
//Parameter order can be confusing
class LegacyComputer
{
    private String CPU, RAM, Storage, GPU, Motherboard;
    private boolean hasWifi, hasBluetooth, hasUSB;

    public LegacyComputer(String CPU, String RAM, String Storage,
                          String GPU, String Motherboard, boolean hasWifi,
                          boolean hasBluetooth, boolean hasUSB)
    {
        this.CPU = CPU;
        this.RAM = RAM;
        this.Storage = Storage;
        this.GPU = GPU;
        this.Motherboard = Motherboard;
        this.hasWifi = hasWifi;
        this.hasBluetooth = hasBluetooth;
        this.hasUSB = hasUSB;

    }
    public LegacyComputer(String CPU)
    {
        this(CPU, "32 GB", "1 TB", "500 GB HDD", "Integrated",
                true, true, true);
    }
    public LegacyComputer(String CPU, String RAM)
    {
        this(CPU, RAM, "1 TB", "500 GB HDD", "Integrated",
                true, true, true);
    }
}
