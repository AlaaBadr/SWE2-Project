package com.edugame.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@CrossOrigin()
	@PostMapping("/edugame/courses/games/{gameName}/comments/addComment")
	public void addComment(@PathVariable("gameName") String gameName, @RequestBody Comment c)
	{
		commentService.addComment(gameName, c);
	}
}
