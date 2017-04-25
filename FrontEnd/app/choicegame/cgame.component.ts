import { Component } from '@angular/core';
import { Level } from "../_models/index";

@Component({
    moduleId: module.id,
    selector: 'cgame',
    templateUrl: 'cgame.component.html'

})

export class cgameComponent {
    rightanswer: number;
    question: string;
    temp: number;
    counter = 1;
    hide = true;
    i = 0;
    length = 0;
    cong = true;
    success = true;
    fail = true;
    levels: any ;
    claclength() {
        this.length++;
    }
    OnClick() {
        if (this.rightanswer == this.levels[this.i].rightanswer) {
            this.i++;
            this.temp = this.counter;
            this.counter++;
            this.success = false;
            this.fail = true;
        } else {
            this.fail = false;
            this.success = true;
        }
        setTimeout(() => {
            this.success = true;
            this.fail = true;
        }, 1000);
        if (this.length == this.counter) {
            this.cong = false;
        }
    }
}