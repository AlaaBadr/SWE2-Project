package com.edugame.level;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.edugame.game.Game;

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
	private int rightAnswer;

	@ManyToOne
	@JoinColumn(name = "name")
	private Game game;

	@Column(name = "answers")
	private ArrayList<String> answers;

	public Level() {
	}

	public Level(String name, String Question, int RightAnswer) {
		levelName = name;
		this.question = Question;
		this.rightAnswer = RightAnswer;
	}

	public String getName() {
		return levelName;
	}

	public void setName(String name) {
		levelName = name;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String Question) {
		this.question = Question;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(int RightAnswer) {
		this.rightAnswer = RightAnswer;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

}
