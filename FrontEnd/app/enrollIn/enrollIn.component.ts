import { Component, OnInit } from '@angular/core';
import { GameService, CourseService, AlertService } from "../_services/index";
import { Router, ActivatedRoute } from "@angular/router";
import { Course } from "../_models/index";

@Component({
    moduleId: module.id,
    templateUrl: 'enrollIn.component.html'

})

export class enrollInComponent implements OnInit {
        constructor(private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService,
        private courseservice: CourseService,
        private gameService: GameService
        
    ) { }
    courses: Course[] = [];
    loggedUser: any;
    id: String;
    onClick(gameName:string){
        localStorage.setItem('gameName',gameName);
        this.router.navigate(['/game']);
    }
    ngOnInit(){
        this.loggedUser = JSON.parse(localStorage.getItem("currentUser"));
        this.getUnEnrolledCourses();
    }
    getCourseGames(listofCourses: Course[]) {
        let counter = 0;
        for (let course of listofCourses) {
            counter++;
            course.id = counter;
            course.games = []
            this.gameService.getGamesOfCourse(course.courseName).subscribe(listOfCourseGames => {
                course.games = listOfCourseGames;
            });
        }
    }
    getUnEnrolledCourses() {
            this.courseservice.showStudentUnenrolledCourses(this.loggedUser.username).subscribe(data => {
            this.courses = data;
            this.getCourseGames(this.courses)
            console.log("teacher courses >>", this.courses);
        });
    }
    enRoll(courseName:string){
        this.courseservice.enrollStudent(this.loggedUser.username,courseName).subscribe(data => {
            this.router.navigate(['/home']);
        });
    }
}