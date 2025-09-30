package com.example.lld.course.BuilderPattern;

public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer basicPC = new Computer
                .Builder("I7", "32GB")
                .build();

        basicPC.displaySpecifications();

        //Centralized Config Logic
        //Reusability
        //Scalability
        Computer.Builder.ComputerDirector director =
                new Computer.Builder.ComputerDirector();

        Computer gamingPC = director.buildGamingPC();
        gamingPC.displaySpecifications();
    }
}

//Step by Step object creation
//Required vs optional fields
//No Parameter order issues
//Immutable and safe construction
//Easy to read and maintain

//Step 1 was to create product class
class Computer {
    private String CPU, RAM, Storage, GPU, Motherboard;
    private boolean hasWifi, hasBluetooth, hasUSB;

    //private Constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
        this.GPU = builder.GPU;
        this.Motherboard = builder.Motherboard;
        this.hasWifi = builder.hasWifi;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasUSB = builder.hasUSB;

    }

    public void displaySpecifications()
    {
        System.out.println("Computer Specifications:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + Storage);
        System.out.println("GPU: " + GPU);
        System.out.println("Motherboard: " + Motherboard);
        System.out.println("hasWifi: " + hasWifi);
        System.out.println("hasBluetooth: " + hasBluetooth);
        System.out.println("hasUSB: " + hasUSB);
    }

    //Step 2: Static Builder Class
    public static class Builder
    {
        private String CPU, RAM, Storage, GPU, Motherboard;
        private boolean hasWifi, hasBluetooth, hasUSB;

        //Required parameters can go in this constructor
        public Builder(String CPU, String RAM)
        {
            this.CPU = CPU;
            this.RAM = RAM;
            //default values for storage, wifi and usb
            //default values can be assigned for all parameters
            //good use case for default specification computer
            this.Storage = "256 GB";
            this.hasWifi = true;
            this.hasUSB = true;
        }

        //Chained Setters for optional parameters
        public Builder Storage (String Storage)
        {
            this.Storage = Storage;
            return this;
        }

        public Builder GPU (String GPU)
        {
            this.GPU = GPU;
            return this;
        }

        //write all the builder methods for all optional parameters

        public Computer build()
        {
            //added validations can be handled here before
            //calling Computer constructor
           // if(this.Motherboard.equalsIgnoreCase("test"))
         //   {
                //throw exception
          //  }
            return new Computer(this);
        }

        //enacapsulate common computer configurations
        static class ComputerDirector
        {
            public Computer buildGamingPC()
            {
                return new Builder("I9", "64GB")
                        .GPU("RTX")
                        .Storage("2TB")
                        .build();
            }

            public Computer buildStudentPC()
            {
                return new Builder("I3", "8GB")
                        .Storage("256 GB")
                        .build();
            }
        }

    }
}


