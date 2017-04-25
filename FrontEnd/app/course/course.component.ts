import { Component } from '@angular/core';
import { Course } from "../_models/index";

@Component({
    moduleId: module.id,
    selector: 'course',
    templateUrl:'course.component.html'
    
})

export class courseComponent { 
    course:any={courseOwner:'mowazaf khawal',description:'course ebn mtnaaaakaa'
    ,students:[{username:'mwzf tany 5wl'},{username:'mwzf talet 5wl brdo'}] 
    ,games:[{gamename:'slm 2wra2',description:'twslha bdl el mwzf el 5wl',nooflevels:3},{gamename:'wl3a',description:'wl5 f 2wm el 4rka w 2tlwb t3wid',nooflevels:3}]};
}
/*
courseName:string;
    courseOwner:string;
    description:string;
    students:Student[];
    games:game[];

    gamename: string;
    description:string;
    nooflevels:number;

*/