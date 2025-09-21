package com.example.lld.LowLevelDesign.DesignPatterns.BuilderDesignPattern;

public class UserMain {

    public static void main(String[] args) {

        User user = new User.UserBuilder("Aditya" ,26)
                .gender("male")
                .phoneNumber("99237824")
                .build();
        User user2 = new User.UserBuilder("Dylan" ,35)
                .build();

        System.out.println(user.toString() + "   phone number: " + user.getPhoneNumber());
        System.out.println(user2.toString()+ "   phone number: " + user2.getPhoneNumber());


    }
}
