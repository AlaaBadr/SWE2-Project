package com.edugame.game;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.edugame.achievements.Achievement;
import com.edugame.course.Course;
import com.edugame.level.Level;
import com.edugame.user.Teacher;

@Entity
@Table(name = "game")
public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5815708378238819773L;

	@Id
	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private Set<Level> levels;

	@OneToMany(mappedBy = "gameinAch", cascade = CascadeType.ALL)
	private Set<Achievement> achievements;

	@ManyToOne
	@JoinColumn(name = "username")
	private Teacher gameOwner;

	@Column(name = "levelno")
	private int levelno;

	@ManyToOne
	@JoinColumn(name = "courseName")
	private Course course;

	public Game() {

	}

	public Game(int Levelno, String name, String type, Teacher Owner) {
		this.name = name;
		this.type = type;
		gameOwner = Owner;
		this.levelno = Levelno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Level> getLevels() {
		return levels;
	}

	public void setLevels(Set<Level> levels) {
		this.levels = levels;
	}

	public int getLevelno() {
		return levelno;
	}

	public void setLevelno(int levelno) {
		this.levelno = levelno;
	}

	public Set<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(Set<Achievement> achievements) {
		this.achievements = achievements;
	}

	public Teacher getGameOwner() {
		return gameOwner;
	}

	public void setGameOwner(Teacher gameOwner) {
		this.gameOwner = gameOwner;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
