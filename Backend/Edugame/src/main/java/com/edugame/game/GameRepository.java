package com.edugame.game;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, String>{

	ArrayList<Game> findByCourseCourseName(String courseName);

	Game findByCourseCourseNameAndName(String courseName, String gameName);

}