import { Component } from 'angular2/core';
import { navbarcomponent } from "./navbar.component";

@Component({
    selector: 'courses',
    templateUrl: 'app/hmtlcomponent/courses.html',
    directives:[navbarcomponent]
})
export class coursescomponent {
}