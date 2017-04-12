package com.edugame.user;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.edugame.course.Course;
import com.edugame.game.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Teacher extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9196215730328920623L;

	@OneToMany(mappedBy = "gameOwner")
	@JsonIgnore
	private Set<Game> games;

	@OneToMany(mappedBy = "courseOwner")
	@JsonIgnore
	private Set<Course> courses;

	public Teacher() {
	}

	public Teacher(String name, String gender, int age, String email, String username, String password) {
		super(name, gender, age, email, username, password);
		setIdentity("Teacher");
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
