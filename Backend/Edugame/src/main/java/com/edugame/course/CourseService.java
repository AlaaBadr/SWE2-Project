package com.edugame.course;

import java.util.ArrayList;
import java.util.List;

import com.edugame.user.Student;
import com.edugame.user.StudentRepository;
import com.edugame.user.Teacher;
import com.edugame.user.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRep;
	
	@Autowired
	private TeacherRepository teacherRep;
	
	@Autowired
	private StudentRepository studentRep;
	
	public CourseService(){
	}
	
	public List<Course> getAllCourses()
	{
		return (List<Course>) courseRep.findAll();
	}
	
	public List<Course> getAllCoursesByTeacher(String username)
	{
		return courseRep.findAllByCourseOwnerUsername(username);
	}
	
	public Course getCourse(String name)
	{
		return courseRep.findOne(name);
	}
	
	/**/
	public Course saveCourse(Course c, String username)
	{
		if(courseRep.findOne(c.getCourseName()) != null)
			return null;
		Teacher t = teacherRep.findByUsername(username);
		c.setCourseOwner(t);
		return courseRep.save(c);
	}

	public List<Course> getAllCoursesByStudent(String username) {
		return studentRep.findByUsername(username).getCourses();
	}

	public Boolean enrollStudent(String courseName, String username) {
		Course c = courseRep.findOne(courseName);
		List<Student> students = c.getStudents();
		Student s = studentRep.findByUsername(username);
		if(students.contains(s))
			return false;
		students.add(s);
		courseRep.save(c);
		return true;
	}
	
	public List<Course> getUnEnrolledCourses(String username){
		List<Course> unenrolledCourses = new ArrayList<Course>();
		List<Course> allCourses = (List<Course>) courseRep.findAll();
		List<Course> enrolledCourses = getAllCoursesByStudent(username);
		for(Course course : allCourses ){
			if(! enrolledCourses.contains(course)){
				unenrolledCourses.add(course);
			}
		}
		
		return unenrolledCourses;
	}
}
