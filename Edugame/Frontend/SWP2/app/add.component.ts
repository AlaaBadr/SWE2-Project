import { Component } from 'angular2/core';
import { navbarcomponent } from "./navbar.component";

@Component({
    selector: 'add',
    templateUrl: 'app/hmtlcomponent/add.html',
    directives:[navbarcomponent]
})
export class addcomponent {
}