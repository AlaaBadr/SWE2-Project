import { Component, OnInit } from '@angular/core';
import { Level, Game, Comment, Course } from "../_models/index";
import { ActivatedRoute, Router } from "@angular/router";
import { Observable } from "rxjs/Rx";
import { AlertService, CourseService, GameService, NotificationService, achievementService } from "../_services/index";
import { CommentService } from "../_services/comment.service";


@Component({
    moduleId: module.id,
  selector: 'app-game',
  templateUrl: './game.component.html'
})
export class GameComponent implements OnInit {

  gameOver: boolean;
    diff: number;
    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService,
        private courseervice: CourseService,
        private gservice: GameService,
        private achservice: achievementService,
        private comService:CommentService,
        private notService:NotificationService  ,
        private gameService: GameService,
        private courseservice: CourseService) { }
        //add notification service
    seconds: number;
    newcourse:Course;
    listOfCourseGames: Game[] = [];
    rightAnswer: string;
    question: string;
    temp: number;
    counter = 1;
    game: any;
    hide = true;
    i = 0;
    length = 0;
    cong = true;
    success = true;
    fail = true;
    gameName: string;
    isTeacher: boolean = false;
    isStudent: boolean = false;
    loggedUser: any;
    answer: string;
    ticks = 0;
    timeOut=60000;
    //comments
    comment:any={};
    comments:Comment[]=[];
    Copy=false;
    course: Course[] = [];
    getright(right: any) {
        this.rightAnswer = right;
        console.log("value >>>", right);
    }
    ngOnInit() {
        this.loggedUser = JSON.parse(localStorage.getItem("currentUser"));
        if (this.loggedUser.identity === "Teacher") {
            this.isTeacher = true;
        }
        else if (this.loggedUser.identity === "Student") {
            this.isStudent = true;
        }
        this.getgamesofcourse();
        /*let timer = Observable.timer(2000,1000);
        timer.subscribe(t=>this.ticks = t);*/
        let timer = Observable.timer(2000, 1000, );
        timer.subscribe(t => this.ticks = t);
        setTimeout(() => {
            this.gameOver=true;
        },this.timeOut);
        this.courseservice.showTeacherCourses(this.loggedUser.username).subscribe(data => {
            this.course = data;
            console.log(data)
        });
    }
    OnClick() {
        if (this.rightAnswer == this.game.levels[this.i].rightAnswer) {
            this.i++;
            this.temp = this.counter;
            this.counter++;
            this.success = false;
            this.fail = true;
            if (this.loggedUser.identity == "Student") {
                console.log("Ach\n");
                this.achservice.addAchievement(this.loggedUser.username, this.game.name, this.i);
            }
        } else {
            this.fail = false;
            this.success = true;
        }
        setTimeout(() => {
            this.success = true;
            this.fail = true;
        }, 1000);
        if (this.length == this.counter + 1) {
            this.cong = false;
        }
    }
    copy(game:Game){
        //console.log(this.newcourse);
        this.gameService.copyGame(game.name,this.newcourse.courseName);
        
    }
    getgamesofcourse() {
        this.gameName = localStorage.getItem('gameName');
        console.log("game to paly",this.gameName);
        this.gservice.getGame(this.gameName).subscribe(data => {
            this.game = data;
            console.log("game>>>>>", this.game);
        }, error => {
            this.alertService.error(error);
        });
        
        //        this.bl7=this.game.levels;
        //      console.log("levels>>>",this.levels);
    }
    onComment(){
        
        this.comment.username=this.loggedUser.username;
        this.comments.push(this.comment);
        console.log("comments >> ",this.comments);
        this.comService.addComment(this.game.name,this.comment);
        this.comment=new Comment();
    }
}
