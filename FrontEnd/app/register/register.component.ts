import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AlertService, UserService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'register.component.html'
})

export class RegisterComponent {
    model: any = {};
    loading = false;
    pattern:string;
    onregister(){
        if(this.model.identity=="Teacher"){
            this.pattern = "[\w.%+-]+@fci.cu.com"
        }else{
             this.pattern="[\w.%+-]";
        }
    }

    constructor(
        private router: Router,
        private userService: UserService,
        private alertService: AlertService) { }

    register() {
        this.loading = true;
      // debugger;
        this.userService.register(this.model,this.model.identity)
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', true);
                    this.router.navigate(['/login']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
