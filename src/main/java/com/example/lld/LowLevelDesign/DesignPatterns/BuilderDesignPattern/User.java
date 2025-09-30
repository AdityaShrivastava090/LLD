package com.example.lld.LowLevelDesign.DesignPatterns.BuilderDesignPattern;

public class User {

    private String name;
    private int age;
    private String gender;
    private String phoneNumber;


    public User(UserBuilder userBuilder) {
        System.out.println("intilaizing all params constructor");
        this.name = userBuilder.name;
        this.age = userBuilder.age;
        this.gender = userBuilder.gender;
        this.phoneNumber = userBuilder.phoneNumber;
    }

    // Step 2:  static builder class
    public static class UserBuilder {
        private String name;
        private int age;
        private String gender;
        private String phoneNumber;

        //Required parameters in builder class constructor
        public UserBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // chaining methods
        public UserBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        //chaining methods
        public UserBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        // write all the builder methods fro all optional fields;
        public User build() {
            // also handle validation on each field
            return new User(this);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
