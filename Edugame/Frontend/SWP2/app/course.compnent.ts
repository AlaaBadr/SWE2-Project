import { Component } from 'angular2/core';
import { navbarcomponent } from "./navbar.component";

@Component({
    selector: 'course',
    templateUrl: 'app/hmtlcomponent/course.html',
    directives:[navbarcomponent]
})
export class coursecomponent {
}