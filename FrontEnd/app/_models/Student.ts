import { User, Course ,Achievement} from "./index";

export class Student extends User {
   courses: Course[];
   achievements:Achievement[];
    
}