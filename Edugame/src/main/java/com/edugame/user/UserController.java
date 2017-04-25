package com.edugame.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edugame.course.Course;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@CrossOrigin()
	@PostMapping("/edugame/login")
	public User login(@RequestBody Student u)
	{
		return userService.search(u.getUsername(),u.getPassword());
	}
	
	@CrossOrigin()
	@PostMapping("/edugame/register/teacher")
	public User registerTeacher(@RequestBody Teacher t)
	{
		return userService.register(t);
	}
	
	@CrossOrigin()
	@PostMapping("/edugame/register/student")
	public User registerStudent(@RequestBody Student s)
	{
		return userService.register(s);
	}
	
	
	
	
}
