package com.edugame.user;

public class Teacher extends User {
	public Teacher() {
    }

    public Teacher(String name, String gender, int age, String email, String username, String password) {
        super(name, gender, age, email, username, password);
        setIdentity("Teacher");
    }
}
