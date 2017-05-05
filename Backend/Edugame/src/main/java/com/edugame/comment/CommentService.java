package com.edugame.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugame.game.Game;
import com.edugame.game.GameRepository;
import com.edugame.notification.NotificationService;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRep;
	
	@Autowired
	private GameRepository gameRep;
	
	@Autowired
	private NotificationService notificationService;

	public void addComment(String gameName, Comment c) {
		Game g = gameRep.findOne(gameName);
		c.setGame(g);
		c.setDate();
		notificationService.commentNotification(gameName);
		commentRep.save(c);
	}
}
