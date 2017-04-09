import { Component } from 'angular2/core';
import { navbarcomponent } from "./navbar.component";

@Component({
    selector: 'search',
    templateUrl: 'app/hmtlcomponent/search.html',
    directives:[navbarcomponent]
})
export class searchcomponent {
}