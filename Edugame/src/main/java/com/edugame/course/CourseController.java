package com.edugame.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	public CourseController(){}
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/edugame/courses")
	public List<Course> showCourses()
	{
		return courseService.getAllCourses();
	}
	
	@GetMapping("/edugame/Courses/{teacherUsername}")
	public List<Course> showTeacherCourses(@PathVariable("teacherUsername") String username)
	{
		return courseService.getAllCoursesByTeacher(username);
	}
	
	@GetMapping("/edugame/courses/{courseName}")
	public Course getCourse(@PathVariable("courseName") String name)
	{
		return courseService.getCourse(name);
	}
	
	@PostMapping("/edugame/courses/{teacherUsername}/addCourse")
	public Course saveCourse(@PathVariable("teacherUsername") String username, @RequestBody Course c) throws InterruptedException
	{
		return courseService.saveCourse(c, username);
	}
}
