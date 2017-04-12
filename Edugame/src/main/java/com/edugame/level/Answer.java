package com.edugame.level;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7269448485397779182L;

	@Id
	@Column(name = "answer")
	private String answer;

	@Id
	@ManyToOne
	@JoinColumn(name = "levelName")
	private Level level;

	public Answer(){}
	
	public Answer(String answer)
	{
		this.answer = answer;
	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}
