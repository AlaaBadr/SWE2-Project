package com.edugame.comment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.edugame.game.Game;

@Entity
@Table(name = "comment")
public class Comment {
	
	@Id
	@Column(name = "date")
	private int date;

	@Column(name = "username")
	private String username;
	
	@Column(name = "comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "name")
	private Game game;

	public Comment(String username, String comment, Game game) {
		super();
		this.date = (int) new Date().getTime();
		this.username = username;
		this.comment = comment;
		this.game = game;
	}

	public int getDate() {
		return date;
	}

	public void setDate() {
		this.date = (int) new Date().getTime();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
