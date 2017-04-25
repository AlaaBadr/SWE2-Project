import { Level, Teacher, Course } from "./index";

export class Game {
    name: string;
    description:string;
    type:string;
    levels:Level[] = [];
    gameOwner: Teacher;
    levelno:number;
    course:Course;
   
   
}

export interface GameType {
    name: string ;
    description:string;
    type:string;
    levels:Level[];
    gameOwner: Teacher;
    levelno:number;
    course:Course;
   
   
}