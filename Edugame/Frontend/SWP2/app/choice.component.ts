import { Component } from 'angular2/core';
import { navbarcomponent } from "./navbar.component";


@Component({
    selector: 'choice',
    templateUrl: 'app/hmtlcomponent/choice.html',
    directives:[navbarcomponent]
    
}) 
export class choicecomponent {
    Answer1="";
    Answer2="";
    Answer3="";
    Answer4="";
    RAnswer="";
}