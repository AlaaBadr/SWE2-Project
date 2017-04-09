package com.edugame.game;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edugame.level.Level;
import com.edugame.user.Teacher;

public class Game {
	private int ID;
    private String name;
    private String type;
    private List<Level> levels;
    private Teacher owner;
    private int levelno;
    public Game() {
        levels= new ArrayList<>();
        
    }
    public Game(int Levelno, String name, String type, Teacher Owner) {
        this.ID= (int) new Date().getTime();
        this.name = name;
        this.type = type;
        this.owner = Owner;
        this.levelno=Levelno;
        levels= new ArrayList<>();
    }
	public int getID() {
		return ID;
	}
	public void setID() {
		ID = (int) new Date().getTime();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Teacher getOwner() {
		return owner;
	}
	public void setOwner(Teacher owner) {
		this.owner = owner;
	}
	public int getLevelno() {
		return levelno;
	}
	public void setLevelno(int levelno) {
		this.levelno = levelno;
	}
    
}
