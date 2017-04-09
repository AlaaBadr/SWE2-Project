package com.edugame.user;

import java.util.ArrayList;
import java.util.List;

import com.edugame.course.Course;

public class Student extends User{
	
	public Student() {
    }

    public Student(String name, String gender, int age, String email, String username, String password) {
        super(name, gender, age, email, username, password);
        setIdentity("Student");
    }
}
