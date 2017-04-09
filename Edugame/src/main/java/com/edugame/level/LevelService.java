package com.edugame.level;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.game.Game;
import com.edugame.game.GameService;

@Service
public class LevelService {

	@Autowired
	private GameService gameService;
	
	public LevelService() throws InterruptedException{
		//gameService = new GameService();
	}
	
	public Level getSpecificLevel(String courseName, String gameName, int levelno)
	{
		Game g = gameService.getGame(courseName, gameName);
		List<Level> levels = g.getLevels();
		if(levelno<=levels.size())
			return levels.get(levelno-1);
		return null;
	}

	public List<Level> getLevels(String courseName, String gameName) {
		Game g = gameService.getGame(courseName, gameName);
		if(g == null)
			return null;
		return g.getLevels();
	}
	
	

}
