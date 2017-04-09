package com.edugame.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edugame.game.Game;
import com.edugame.user.Student;
import com.edugame.user.Teacher;

public class Course {

	private String name;
	private int id;
	private Teacher owner;
	private String description;
	private List<Student> students;
	private List<Game> games;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId() throws InterruptedException {
		Thread.sleep(2000);
		this.id = (int) new Date().getTime();
	}
	public Teacher getOwner() {
		return owner;
	}
	public void setOwner(Teacher owner) {
		this.owner = owner;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
	public Course(String name, Teacher owner, String description) throws InterruptedException {
		super();
		this.name = name;
		this.owner = owner;
		this.description = description;
		setId();
		students = new ArrayList<>();
		games = new ArrayList<>();
	}
	
	public Course(){}
}
