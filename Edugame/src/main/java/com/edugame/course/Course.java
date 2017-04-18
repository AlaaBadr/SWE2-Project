package com.edugame.course;

import java.io.Serializable;
import java.util.List;

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
	private List<Student> students;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Game> games;

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
		courseName = name;
		courseOwner = owner;
		this.description = description;
	}

	public Course() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((courseOwner == null) ? 0 : courseOwner.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((games == null) ? 0 : games.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (courseOwner == null) {
			if (other.courseOwner != null)
				return false;
		} else if (!courseOwner.equals(other.courseOwner))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (games == null) {
			if (other.games != null)
				return false;
		} else if (!games.equals(other.games))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}
	
}
