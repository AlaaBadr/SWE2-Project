import { Component, OnInit } from '@angular/core';
import { Level, Course, Game } from "../_models/index";
import { ActivatedRoute, Router } from "@angular/router";
import { AlertService, CourseService, GameService } from "../_services/index";

@Component({
    moduleId: module.id,
    selector: 'tfgame',
    templateUrl: 'tfgame.component.html'
})

export class tfgameComponent implements OnInit {
    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService,
        private courseervice: CourseService,
        private gservice: GameService) { }
    listOfCourseGames:Game[]=[];
    rightanswer: string;
    question: string;
    temp: number;
    counter = 1;
    course: Course;
    hide = true;
    i = 0;
    length = 0;
    cong = true;
    success = true;
    fail = true;
    levels: Level[];
    ngOnInit() {
        debugger;
        console.log("here")
 //       this.course = JSON.parse(localStorage.getItem('course'));
        this.gservice.getGamesOfCourse('C++').subscribe(data => {
            this.listOfCourseGames = data;
            console.log(data)
        });
        setTimeout(() => {
            console.log("courses game >> ", this.listOfCourseGames);

        }, 2000);
      //  this.levels=this.game[0].levels;
     //   this.length=this.levels.length;
    }
    /* claclength() {
         this.length++;
     }*/
    OnClick() {
        if (this.rightanswer == this.levels[this.i].rightAnswer) {
            this.i++;
            this.temp = this.counter;
            this.counter++;
            this.success = false;
            this.fail = true;
        } else {
            this.fail = false;
            this.success = true;
        }
        setTimeout(() => {
            this.success = true;
            this.fail = true;
        }, 1000);
        if (this.length == this.counter+1) {
            this.cong = false;
        }
    }
}
