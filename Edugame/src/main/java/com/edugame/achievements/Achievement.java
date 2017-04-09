package com.edugame.achievements;

public class Achievement {

	private int Score;
	private String gameName;
	
	Achievement(){}
	
	public Achievement(int score, String gameName) {
		super();
		Score = score;
		this.gameName = gameName;
	}

	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public String getgameName() {
		return gameName;
	}
	public void setgameName(String gameName) {
		this.gameName = gameName;
	}
	
	
}
