import { Component } from '@angular/core';
import { Student } from "../_models/index";
import { CourseService } from "../_services/index";
import { achievementService } from "../_services/index";

@Component({
    moduleId: module.id,
    selector: 'studnet',
    templateUrl: 'app.component.html'
})

export class studentComponent {
    constructor(private student:Student,
                private courseservice:CourseService,
                private achservice:achievementService){}
    ngOnInit(){
        this.achservice.showAchievements(this.student.username);
        this.courseservice.showStudentCourses(this.student.username);
    }
 }
//app.component.html