package com.edugame.level;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.game.Game;
import com.edugame.game.GameService;

@Service
public class LevelService {

	@Autowired
	private LevelRepository levelRep;
	
	@Autowired
	private GameService gameService;
	
	public LevelService() throws InterruptedException{
		//gameService = new GameService();
	}
	
	public Level getSpecificLevel(String gameName, int levelno)
	{
		/*
		Game g = gameService.getGame(courseName, gameName);
		List<Level> levels = g.getLevels();
		if(levelno<=levels.size())
			return levels.get(levelno-1);
		*/
		return levelRep.findByGameNameAndNumber(gameName, levelno);
	}

	public List<Level> getLevels(String gameName)
	{
		/*
		Game g = gameService.getGame(courseName, gameName);
		if(g == null)
			return null;
		return g.getLevels();
		*/
		return levelRep.findAllByGameName(gameName);
	}
	
	

}
