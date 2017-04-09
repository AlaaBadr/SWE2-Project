import { Component } from 'angular2/core';
import { Sizedirective } from "./Size.directive";
import { formcomponent } from "./form.component";
import { welcomecomponent } from "./welcome.component";
import { searchcomponent } from "./search.component";
import { tfcomponent } from "./tf.component";
import { choicecomponent } from "./choice.component";
import { addcomponent } from "./add.component";
import { coursecomponent } from "./course.compnent";
import { coursescomponent } from "./courses.component";
import { homepagecomponent } from "./homepage.component";


@Component({
    selector: 'my-app',
    template: `<form></form>`,
    directives: [addcomponent, choicecomponent, coursecomponent, coursescomponent, formcomponent, homepagecomponent, searchcomponent
        , Sizedirective, tfcomponent, welcomecomponent]

})
export class AppComponent { }
/*
<add></add>
<tf></tf>
<course></course>
<form></form>
<search></search>
<welcome></welcome>
*/