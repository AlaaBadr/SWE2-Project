package com.edugame.course;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.edugame.game.Game;
import com.edugame.user.Student;
import com.edugame.user.Teacher;

@Entity
@Table(name = "course")
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7540082667189659715L;

	@Id
	@Column(name = "courseName")
	private String courseName;

	@ManyToOne
	@JoinColumn(name = "username")
	private Teacher courseOwner;

	@Column(name = "description")
	private String description;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "studentCourses", joinColumns = @JoinColumn(name = "courseName", referencedColumnName = "courseName"), inverseJoinColumns = @JoinColumn(name = "studentUsername", referencedColumnName = "username"))
	private Set<Student> students;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Game> games;

	public Teacher getCourseOwner() {
		return courseOwner;
	}

	public void setCourseOwner(Teacher courseOwner) {
		this.courseOwner = courseOwner;
	}

	public String getName() {
		return courseName;
	}

	public void setName(String name) {
		courseName = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public Course(String name, Teacher owner, String description) throws InterruptedException {
		super();
		courseName = name;
		courseOwner = owner;
		this.description = description;
	}

	public Course() {
	}
}
