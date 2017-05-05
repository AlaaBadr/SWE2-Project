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

import com.edugame.user.Teacher;

@RestController
public class CourseController {
	
	public CourseController(){}
	
	@Autowired
	private CourseService courseService;
	
	@CrossOrigin()
	@GetMapping("/edugame/courses")
	public List<Course> showCourses()
	{
		List<Course> result = courseService.getAllCourses();
		for( Course c : result)
		{
			Teacher t = new Teacher();
			t.setUsername(c.getCourseOwner().getUsername());
			c.setCourseOwner(t);
			c.setStudents(null);
		}
		return result;
	}
	
	@CrossOrigin()
	@GetMapping("/edugame/Courses/{teacherUsername}")
	public List<Course> showTeacherCourses(@PathVariable("teacherUsername") String username)
	{
		List<Course> result = courseService.getAllCoursesByTeacher(username);
		for( Course c : result)
		{
			Teacher t = new Teacher();
			t.setUsername(c.getCourseOwner().getUsername());
			c.setCourseOwner(t);
			c.setStudents(null);
		}
		return result;
	}
	
	@CrossOrigin()
	@GetMapping("/edugame/enrolledCourses/{studentUsername}")
	public List<Course> showStudentCourses(@PathVariable("studentUsername") String username)
	{
		List<Course> result = courseService.getAllCoursesByStudent(username);
		for( Course c : result)
		{
			Teacher t = new Teacher();
			t.setUsername(c.getCourseOwner().getUsername());
			c.setCourseOwner(t);
			c.setStudents(null);
		}
		return result;
	}
	
	
	@CrossOrigin()
	@GetMapping("/edugame/courses/{courseName}")
	public Course getCourse(@PathVariable("courseName") String name)
	{
		Course c = courseService.getCourse(name);
		c.setCourseOwner(null);
		c.setStudents(null);
		return c;
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
		List<Course> result = courseService.getUnEnrolledCourses(username);
		for( Course c : result)
		{
			Teacher t = new Teacher();
			t.setUsername(c.getCourseOwner().getUsername());
			c.setCourseOwner(t);
			c.setStudents(null);
		}
		return result;
	}
}
