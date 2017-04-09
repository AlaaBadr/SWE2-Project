package com.edugame.enrollement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edugame.course.Course;

@RestController
public class EnrollementController {

	@Autowired
	private EnrollementService enrollementService;
	
	@RequestMapping("/showCourses/student/{studentUsername}")
	public List<Course> showStudentCourses(@PathVariable("studentUsername") String username)
	{
		return enrollementService.getStudentCourses(username);
	}
	
	@PostMapping("/enroll")
	public Boolean enroll(@RequestParam("username") String username, @RequestParam("courseName") String courseName)
	{
		return enrollementService.enroll(username, courseName);
	}
}
