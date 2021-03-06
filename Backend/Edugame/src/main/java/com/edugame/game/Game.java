package com.edugame.game;

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

import com.edugame.achievements.Achievement;
import com.edugame.comment.Comment;
import com.edugame.course.Course;
import com.edugame.level.Level;
import com.edugame.user.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Column(name = "description")
	private String description;
	
	@Column(name = "type")
	private String type;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<Level> levels;

	@OneToMany(mappedBy = "gameinAch", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Achievement> achievements;

	@ManyToOne
	@JoinColumn(name = "username")
	private Teacher gameOwner;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "gameCollaborators", joinColumns = @JoinColumn(name = "gameName", referencedColumnName = "name"), inverseJoinColumns = @JoinColumn(name = "TeacherUsername", referencedColumnName = "username"))
	private List<Teacher> gameCollaborators;

	@Column(name = "levelno")
	private int levelno;

	@ManyToOne
	@JoinColumn(name = "courseName")
	private Course course;
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<Comment> comments;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	public List<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<Achievement> achievements) {
		this.achievements = achievements;
	}

	public Teacher getGameOwner() {
		return gameOwner;
	}

	public void setGameOwner(Teacher gameOwner) {
		this.gameOwner = gameOwner;
	}

	public int getLevelno() {
		return levelno;
	}

	public void setLevelno(int levelno) {
		this.levelno = levelno;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public List<Teacher> getGameCollaborators() {
		return gameCollaborators;
	}

	public void setGameCollaborators(List<Teacher> gameCollaborators) {
		this.gameCollaborators = gameCollaborators;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((achievements == null) ? 0 : achievements.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((gameOwner == null) ? 0 : gameOwner.hashCode());
		result = prime * result + levelno;
		result = prime * result + ((levels == null) ? 0 : levels.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Game other = (Game) obj;
		if (achievements == null) {
			if (other.achievements != null)
				return false;
		} else if (!achievements.equals(other.achievements))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (gameOwner == null) {
			if (other.gameOwner != null)
				return false;
		} else if (!gameOwner.equals(other.gameOwner))
			return false;
		if (levelno != other.levelno)
			return false;
		if (levels == null) {
			if (other.levels != null)
				return false;
		} else if (!levels.equals(other.levels))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
