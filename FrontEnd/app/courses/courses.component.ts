import { Component } from '@angular/core';
import { Teacher, Course, Game } from "../_models/index";
import { CourseService } from "../_services/index";
import { achievementService, AlertService, GameService } from "../_services/index";
import { ActivatedRoute, Router } from "@angular/router";


@Component({
    moduleId: module.id,
    templateUrl: 'courses.component.html'
})

export class coursesComponent {
    constructor(private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService,
        private courseservice: CourseService,
        private gameService: GameService,
    ) { }
    courses: Course[] = [];
    private loggedUser: any;
    id: String;
    gameurl: string;
    isStudent: boolean = false;
    isTeacher: boolean = false;
    newcourse:Course;
    Copy=false;
    Cs: Course[] = [];
    ngOnInit() {

        this.loggedUser = JSON.parse(localStorage.getItem("currentUser"));
        if (this.loggedUser.identity == "Teacher") {
            this.isTeacher = true;
        }
        else if (this.loggedUser.identity == "Student") {
            this.isStudent = true;
        }
        this.getCourses();
        this.courseservice.showTeacherCourses(this.loggedUser.username).subscribe(data => {
            this.Cs = data;
            console.log(data)
        });
    }
    onClick(gameName:string){
        localStorage.setItem('gameName',gameName); 
        this.router.navigate(['/game']);
    }
    copy(game:Game){
        //console.log(this.newcourse);
        this.gameService.copyGame(game.name,this.newcourse.courseName);
        
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
        getCourses() {
        this.courseservice.showCourses().subscribe(data => {
            this.courses = data;
            this.getCourseGames(this.courses)
            console.log("teacher courses >>", this.courses)
        });
    }
}
