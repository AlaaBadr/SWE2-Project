import { User, Game, Course } from "./index";

export class Teacher extends User {

    games: Game[];
    courses: Course[];
}