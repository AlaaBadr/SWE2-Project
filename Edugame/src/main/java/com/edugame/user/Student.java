package com.edugame.user;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.edugame.achievements.Achievement;
import com.edugame.achievements.AchievementID;
import com.edugame.course.Course;

@Entity
public class Student extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9181249412970690507L;

	@ManyToMany(mappedBy = "students")
	private Set<Course> courses;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Set<Achievement> achivements;

	public Student() {
	}

	public Student(String name, String gender, int age, String email, String username, String password) {
		super(name, gender, age, email, username, password);
		setIdentity("Student");
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<Achievement> getAchivements() {
		return achivements;
	}

	public void setAchivements(Set<Achievement> achivements) {
		this.achivements = achivements;
	}

	
	
}
