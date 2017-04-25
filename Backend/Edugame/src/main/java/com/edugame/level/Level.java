package com.edugame.level;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.edugame.game.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "level")
public class Level implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6941237780979218200L;

	@Id
	@Column(name = "levelName")
	private String levelName;

	@Column(name = "question")
	private String question;

	@Column(name = "number")
	private int number;

	@Column(name = "rightAnswer")
	private String rightAnswer;

	@ManyToOne
	@JoinColumn(name = "name")
	@JsonIgnore
	private Game game;

	@Column(name = "answers")
	private ArrayList<String> answers;

	public Level() {
	}

	public Level(String name, String Question, String RightAnswer) {
		levelName = name;
		this.question = Question;
		this.rightAnswer = RightAnswer;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
	

	
}
