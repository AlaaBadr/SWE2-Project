import { Component, OnInit } from '@angular/core';
import { Level, Game } from "../_models/index";
import { ActivatedRoute, Router } from "@angular/router";
import { AlertService, CourseService, GameService } from "../_services/index";

@Component({
    moduleId: module.id,
    templateUrl: 'game.component.html'
})

export class gameComponent implements OnInit {
    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService,
        private courseervice: CourseService,
        private gservice: GameService) { }
    listOfCourseGames:Game[]=[];
    rightanswer: number;
    question: string;
    temp: number;
    counter = 1;
    game:any;
    hide = true;
    i = 0;
    length = 0;
    cong = true;
    success = true;
    fail = true;
    index=0;
    gameName:string;
    isTeacher:boolean=false;
    isStudent:boolean=false;
    loggedUser:any;
    ngOnInit() {
        this.loggedUser = JSON.parse(localStorage.getItem("currentUser"));
        if (this.loggedUser.identity == "Teacher") {
            this.isTeacher = true;
        }
        else if (this.loggedUser.identity == "Student") {
            this.isStudent = true;
        }
       this.getgamesofcourse();
    }

    OnClick() {
        if (this.rightanswer == this.game.levels[this.i].rightAnswer) {
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
    getgamesofcourse()
    {
        this.gameName=localStorage.getItem('gameName');
        this.gservice.getGame(this.gameName).subscribe(data => {
            this.game = data;
            console.log("game>>>>>",this.game);
            },error => {
                    this.alertService.error(error);
                })
//        this.bl7=this.game.levels;
  //      console.log("levels>>>",this.levels);

    }
}











  //      console.log("here")
 //       this.course = JSON.parse(localStorage.getItem('course'));
 /*       this.gservice.getGamesOfCourse('C++').subscribe(data => {
            this.listOfCourseGames = data;
            console.log(data)
        });*/
       /* setTimeout(() => {
            console.log("courses game >> ", this.listOfCourseGames);

        }, 2000);*/
      //  this.levels=this.game[0].levels;
     //   this.length=this.levels.length;