package com.edugame.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	public CourseController(){}
	
	@Autowired
	private CourseService courseService;
	
	@CrossOrigin()
	@GetMapping("/edugame/courses")
	public List<Course> showCourses()
	{
		return courseService.getAllCourses();
	}
	
	@CrossOrigin()
	@GetMapping("/edugame/Courses/{teacherUsername}")
	public List<Course> showTeacherCourses(@PathVariable("teacherUsername") String username)
	{
		return courseService.getAllCoursesByTeacher(username);
	}
	
	@CrossOrigin()
	@GetMapping("/edugame/enrolledCourses/{studentUsername}")
	public List<Course> showStudentCourses(@PathVariable("studentUsername") String username)
	{
		return courseService.getAllCoursesByStudent(username);
	}
	
	
	@CrossOrigin()
	@GetMapping("/edugame/courses/{courseName}")
	public Course getCourse(@PathVariable("courseName") String name)
	{
		return courseService.getCourse(name);
	}
	
	@CrossOrigin()
	@PostMapping("/edugame/courses/{teacherUsername}/addCourse")
	public Course saveCourse(@PathVariable("teacherUsername") String username, @RequestBody Course c) throws InterruptedException
	{
		return courseService.saveCourse(c, username);
	}
	@CrossOrigin()
	@GetMapping("/edugame/courses/{courseName}/enroll/{studentUsername}")
	public Boolean enrollStudent(@PathVariable("courseName") String courseName, @PathVariable("studentUsername") String username)
	{
		return courseService.enrollStudent(courseName, username);
	}
	
	@CrossOrigin()
	@GetMapping("/edugame/unenrolledCourses/{studentUsername}")
	public List<Course> showUnErolledCourses(@PathVariable("studentUsername") String username)
	{
		return courseService.getUnEnrolledCourses(username);
	}
}
