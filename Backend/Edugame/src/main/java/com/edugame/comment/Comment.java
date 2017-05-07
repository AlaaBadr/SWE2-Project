package com.edugame.comment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.edugame.game.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comment")
public class Comment {
	
	@Id
	@Column(name = "date")
	private long date;

	@Column(name = "username")
	private String username;
	
	@Column(name = "comment")
	private String comment;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "name")
	private Game game;

	public Comment()
	{
		
	}
	
	public Comment(String username, String comment) {
		super();
		this.date = (long) new Date().getTime();
		this.username = username;
		this.comment = comment;
	}

	public long getDate() {
		return date;
	}

	public void setDate() {
		this.date = (long) new Date().getTime();
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
