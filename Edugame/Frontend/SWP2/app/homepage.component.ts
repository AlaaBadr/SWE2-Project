import { Component } from 'angular2/core';
import { navbarcomponent } from "./navbar.component";

@Component({
    selector: 'homepage',
    templateUrl: 'app/hmtlcomponent/homepage.html',
    directives:[navbarcomponent]
})
export class homepagecomponent {
}