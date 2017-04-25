import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Level, Game, Teacher, Course } from "../_models/index";
import { AlertService, GameService, CourseService, } from '../_services/index';
import { GameType } from "../_models/Game";

@Component({

    moduleId: module.id,
    selector: 'add',
    templateUrl: "addgame.component.html"
})

export class addgameComponent implements OnInit {
    loading: boolean = true;


    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService,
        private courseervice: CourseService,
        private gservice: GameService) {
    }
    /*constructor( private gameservice:GameService, private router: Router, private teacherUserName: string) {
         this.game.gameOwner = teacherUserName;
     }*/
    course: Course[] = [];
    game: Game = new Game();
    levels: Level[] = [];
    level: any = {};
    choicea: string = "";
    choiceb: string;
    choicec: string;
    choiced: string;
    counter: number = 0;
    levelnumber = 1;
    mode: string = 'Done!';
    typetf: boolean = true;
    typec: boolean = true;
    rightanswer: number;
    coursename: string;
    teacher: Teacher = JSON.parse(localStorage.getItem('user'));
    isTeacher: boolean = true;
    isStudent: boolean = true;
    loggedUser: any;
    //function search and add course to game
    ngOnInit() {
        this.loggedUser = JSON.parse(localStorage.getItem("currentUser"));
        if (this.loggedUser.identity == "Teacher") {
            this.isTeacher = true;
        }
        else if (this.loggedUser.identity == "Student") {
            this.isStudent = true;
        }
        this.courseervice.showCourses().subscribe(data => {
            this.course = data;
            console.log(data)
        });
        setTimeout(() => {
            console.log("courses data >> ", this.course);

        }, 2000);

    }
    OnDone() {

        if (this.mode == 'Done!' && this.game.type == 'true-false') {
            this.typetf = false;
            this.mode = "Edit!";
        }
        else if (this.mode == 'Done!' && this.game.type == 'choice') {
            this.typec = false;
            this.mode = "Edit!";
        }
        else {
            this.typetf = true;
            this.typec = true;
            this.game.levelno = 0;
            this.mode = "Done!";
            this.game.levels = [];
        }

    }
    /*
    addcourse(){
        this.newcourse="";
        this.course.courseOwner=this.teacher;
           this.courseservice. saveCourse(this.course,this.teacher) ;

    }
    */
    levelsEnd() {
        //debugger;
        this.counter++;
        this.level.number = this.levelnumber;
        this.levelnumber++;
        //this.level.rightanswer=this.rightanswer;
        if (this.game.type == 'true-false') {
            this.level.answers = ["True", "False"];
        } else {
            this.level.answers = [this.choicea, this.choiceb, this.choicec, this.choiced];
        }
        this.levels.push(this.level);
        if (this.counter == this.game.levelno) {
            this.game.levels = this.levels;
            //console.log("course name ", this.game);
            localStorage.setItem('course', JSON.stringify(this.game.course));
            this.gservice.addgame(this.teacher.username, this.game.course.courseName, this.game).subscribe(
                data => {
                    this.router.navigate(['/tfgame']);

                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
        }
    }
}
