import { Student, Game, Teacher } from "./index";

export class Course {
    courseName:string;
    courseOwner:Teacher;
    description:string;
    games:Game[]=[];
    id : number
    //students:Student[];
}