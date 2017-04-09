package com.edugame.user;

public class Student extends User{
	
	public Student() {
    }

    public Student(String name, String gender, int age, String email, String username, String password) {
        super(name, gender, age, email, username, password);
        setIdentity("Student");
    }
}
