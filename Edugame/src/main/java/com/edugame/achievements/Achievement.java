package com.edugame.achievements;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.edugame.game.Game;
import com.edugame.user.Student;

@Entity
@Table(name = "achievement")
@IdClass(AchievementID.class)
public class Achievement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6733006826848577088L;

	@Column(name = "score")
	private int score;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "studentUsername")
	private Student student;

	@Id
	@ManyToOne
	@JoinColumn(name = "gameName")
	private Game gameinAch;

	//private AchievementID achId;

	Achievement() {
		//achId = new AchievementID();
	}

	public Achievement(int score, Student s, Game g) {
		super();
		this.score = score;
		student = s;
		gameinAch = g;
		//achId = ach;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Game getGameinAch() {
		return gameinAch;
	}

	public void setGameinAch(Game gameinAch) {
		this.gameinAch = gameinAch;
	}

//	public AchievementID getAchId() {
//		return achId;
//	}
//
//	public void setAchId(AchievementID achId) {
//		this.achId = achId;
//	}
	

}