package com.edugame.level;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LevelController {

	@Autowired
	private LevelService levelService;
	
	@RequestMapping("/playGame/{gameName}/{levelno}")
	public Level getLevel(@PathVariable("gameName") String gameName, @PathVariable("levelno") int levelno)
	{
		return levelService.getSpecificLevel(gameName, levelno);
	}
	
	//ERROR!!
	//Game is null!!
	@RequestMapping("/playGame/{gameName}")
	public List<Level> getLevels(@PathVariable("gameName") String gameName)
	{
		return levelService.getLevels(gameName);
	}
}
