package com.example.lld.course.BuilderPattern.practise;

public class User {

    private String username;
    private String dob;
    private String address;
    private String hobbies;

    public User(Builder builder) {
        this.address = builder.address;
        this.username = builder.username;
        this.dob = builder.dob;
        this.hobbies = builder.hobbies;
    }

    static class Builder {
        private String username;
        private String dob;
        private String address;
        private String hobbies;

        public Builder(String username, String address) {
            this.address = address;
            this.username = username;
        }

        public Builder dob(String dob) {
            this.dob = dob;
            return this;

        }

        public Builder hobbies(String hobbies) {
            this.hobbies = hobbies;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


    public static void main(String[] args) {
        User user1 = new Builder("aditya", "noida")
                .dob("April")
                .hobbies("footbal")
                .build();

        User user2 = new Builder("shubh", "noida")
                .dob("july")
                .hobbies("criicket")
                .build();

        System.out.println(user1.toString());
        System.out.println(user2.toString());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }


}
