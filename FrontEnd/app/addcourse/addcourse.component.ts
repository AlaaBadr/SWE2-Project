import { Component, OnInit } from '@angular/core';
import { CourseService, AlertService } from "../_services/index";
import { Router, ActivatedRoute } from "@angular/router";
import { Course, User } from "../_models/index";

@Component({
    moduleId: module.id,
    selector: 'addcourse',
    templateUrl:'addcourse.component.html'
    
})

export class addcourseComponent implements OnInit  {
    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService,
        private courseservice:CourseService
        ) { }
    //constructor(private courseservice:CourseService){}
    isTeacher:boolean=true;
    isStudent:boolean=true;
    loggedUser:any;
    ngOnInit() {
        this.loggedUser = JSON.parse(localStorage.getItem("currentUser"));
        if (this.loggedUser.identity == "Teacher") {
            this.isTeacher = true;
        }
        else if (this.loggedUser.identity == "Student") {
            this.isStudent = true;
        }
    }
    course:any={};
    teacherusername=localStorage.getItem('user');
    loading = false;
    user:User=JSON.parse(localStorage.getItem('user'));
    addcourse(){
        this.loading = true;
       // this.course.courseOwner=this.user.username;
        //debugger;
        //,this.user.username
       this.courseservice.saveCourse(this.user.username,this.course).subscribe(
                data => { 
                    this.router.navigate(['/login']);
                    
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
    }
