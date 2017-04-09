package com.edugame.achievements;

import com.edugame.game.Game;

public class Achievement {

	private int Score;
	private Game g;
	
	Achievement(){}
	
	public Achievement(int score, Game g) {
		super();
		Score = score;
		this.g = g;
	}

	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public Game getGame() {
		return g;
	}
	public void setGame(Game g) {
		this.g = g;
	}
	
	
}
