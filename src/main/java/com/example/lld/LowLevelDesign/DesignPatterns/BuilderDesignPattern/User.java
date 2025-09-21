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

    public static class UserBuilder {
        private String name;
        private int age;
        private String gender;
        private String phoneNumber;

        public UserBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public UserBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User build() {
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
