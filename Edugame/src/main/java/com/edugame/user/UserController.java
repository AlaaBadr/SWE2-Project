package com.edugame.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/edugame/login")
	public User login(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		return userService.search(username,password);
	}
	
	@PostMapping("/edugame/register/teacher")
	public User registerTeacher(@RequestBody Teacher t)
	{
		return userService.register(t);
	}
	
	@PostMapping("/edugame/register/student")
	public User registerStudent(@RequestBody Student s)
	{
		return userService.register(s);
	}
}
