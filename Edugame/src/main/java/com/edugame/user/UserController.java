package com.edugame.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	

	@RequestMapping("/hello")
	public String sayHello()
	{
		return "Say Hello ya 7ayawan";
	}
	
	@PostMapping("/login")
	public User login(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		return userService.search(username,password);
	}
	
	@PostMapping("/register/teacher")
	public User registerTeacher(@RequestBody Teacher t)
	{
		return userService.register(t);
	}
	
	@PostMapping("/register/student")
	public User registerStudent(@RequestBody Student s)
	{
		//System.out.println("da5al elservice");
		//System.out.println(s.getUsername());
		return userService.register(s);
	}
}
