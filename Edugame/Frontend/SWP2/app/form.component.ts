import {Component} from 'angular2/core';
import { registerservice } from './register.service'
import { HTTP_PROVIDERS } from "angular2/http";
@Component({
    selector: 'form',
    templateUrl: 'app/hmtlcomponent/form.html',
    providers:[registerservice,HTTP_PROVIDERS]
})
export class formcomponent {
    
     onSubmit(form)
    {
        console.log(form);
    }
    constructor(private _register: registerservice)
    {
      this._register.senddata().subscribe(object=>console.log(object=>console.log(object)));
    }
}