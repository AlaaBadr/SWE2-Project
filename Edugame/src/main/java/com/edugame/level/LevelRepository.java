package com.edugame.level;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LevelRepository extends CrudRepository<Level, String>{

	Level findByGameNameAndNumber(String gameName, int number);

	List<Level> findAllByGameName(String gameName);

}
