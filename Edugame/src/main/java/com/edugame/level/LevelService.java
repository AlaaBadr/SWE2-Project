package com.edugame.level;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edugame.game.Game;
import com.edugame.game.GameService;

@Service
public class LevelService {

	private GameService gameService;
	
	public LevelService() throws InterruptedException
	{
		gameService = new GameService();
	}
	
	public Level getSpecificLevel(String courseName, String gameName, int levelno)
	{
		Game g = gameService.getGame(courseName, gameName);
		List<Level> levels = g.getLevels();
		for(Level l: levels)
		{
			if(l.getNumber() == levelno)
				return l;
		}
		return null;
	}

	public List<Level> getLevels(String courseName, String gameName) {
		Game g = gameService.getGame(courseName, gameName);
		if(g == null)
			return null;
		return g.getLevels();
	}
	
	

}
