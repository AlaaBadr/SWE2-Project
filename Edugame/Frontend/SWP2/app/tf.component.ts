import { Component } from 'angular2/core';
import { navbarcomponent } from "./navbar.component";


@Component({
    selector: 'tf',
    templateUrl: 'app/hmtlcomponent/tf.html',
    directives:[navbarcomponent]
    
})
export class tfcomponent {
    q="karim";
}