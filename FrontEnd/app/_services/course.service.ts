import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Course } from '../_models/index';

@Injectable()
export class CourseService {
    constructor(private http: Http) { }
    url = 'http://localhost:8080';

    setJSONHeaders() {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return options;
    }
    showCourses() {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.get(this.url + '/edugame/courses', options).map((response: Response) => response.json());
    }

    showTeacherCourses(username: string) {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.get('http://localhost:8080/edugame/Courses/' + username, options).map((response: Response) => response.json());
    }

    getCourse(course: Course) {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('http://localhost:8080/edugame/courses' + course.courseName, course.courseName, options).map((response: Response) => response.json());
    }

    saveCourse(username: string, course: Course, ) {
        //debugger;
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.url + '/edugame/courses/' + username + '/addCourse', course, options
        ).map((response: Response) => response.json());
    }
    showStudentCourses(username: string) {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.get('http://localhost:8080/edugame/enrolledCourses/' + username, options).map((response: Response) => response.json());
    }

    showStudentUnenrolledCourses(username: string) {
        return this.http.get('http://localhost:8080/edugame/unenrolledCourses/' + username, this.setJSONHeaders()).map((response: Response) => response.json());
    }







}