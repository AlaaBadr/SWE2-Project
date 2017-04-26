package com.edugame.level;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.game.GameRepository;

@Service
public class LevelService {

	@Autowired
	private LevelRepository levelRep;
	
	@Autowired
	private GameRepository gameRep;
			
	public LevelService(){
	}
	
	public Level getSpecificLevel(String gameName, int levelno)
	{
		return levelRep.findByGameNameAndNumber(gameName, levelno);
	}

	public List<Level> getLevels(String gameName)
	{
		return levelRep.findAllByGameName(gameName);
	}
	
	public Boolean addLevel(Level l, String gameName)
	{
		if(levelRep.findOne(l.getLevelName()) != null)
			return false;
		l.setGame(gameRep.findOne(gameName));
		levelRep.save(l);
		return true;
	}
	
	/*
	public Boolean checkAnswer(String username, String gameName, int levelno, int rightAnswer) {
		Level l = getSpecificLevel(gameName, levelno);
		if(rightAnswer == l.getRightAnswer())
		{
			achService.addAchievement(username, gameName, levelno);
			return true;
		}
		return false;
	}
	*/

}
