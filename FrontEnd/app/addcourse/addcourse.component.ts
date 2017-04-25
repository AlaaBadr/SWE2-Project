import { Component } from '@angular/core';
import { CourseService, AlertService } from "../_services/index";
import { Router, ActivatedRoute } from "@angular/router";
import { Course, User } from "../_models/index";

@Component({
    moduleId: module.id,
    selector: 'addcourse',
    templateUrl:'addcourse.component.html'
    
})

export class addcourseComponent  {
    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService,
        private courseservice:CourseService
        ) { }
    //constructor(private courseservice:CourseService){}
    
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
