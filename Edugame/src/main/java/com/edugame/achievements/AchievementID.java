package com.edugame.achievements;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.edugame.game.Game;
import com.edugame.user.Student;

//@Entity
public class AchievementID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8597626675298796154L;

	//@Id
	//@ManyToOne
	//@JoinColumn(name = "studentUsername")
	private Student student;

//	@Id
//	@ManyToOne
//	@JoinColumn(name = "gameName")
	private Game gameinAch;
	
	public AchievementID()
	{
		
	}
	
	public AchievementID(Student s, Game g) {
		student = s;
		gameinAch = g;
	}

	public Student getStudent() {
		return student;
	}

	public Game getGame() {
		return gameinAch;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameinAch == null) ? 0 : gameinAch.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		AchievementID other = (AchievementID) obj;
		if (gameinAch == null) {
			if (other.gameinAch != null)
				return false;
		} else if (!gameinAch.equals(other.gameinAch))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

}

