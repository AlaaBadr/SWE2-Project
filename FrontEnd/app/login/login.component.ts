import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {addgameComponent} from '../addgame/index'
import { AlertService, AuthenticationService } from '../_services/index';
import { addcourseComponent } from "../addcourse/index";
import { User } from "../_models/index";



@Component({
    moduleId: module.id,
    templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
    user:User;
    model:any={};
    loading = false;
    returnUrl: string;
    addgame:addgameComponent;
    addcourse:addcourseComponent;
    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService) { }
    ngOnInit() {
        // reset login status
        this.authenticationService.logout();

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }
    login() {
        this.loading = true;
        this.authenticationService.login(this.model)
            .subscribe(
                data => { 
                    // login successful if there's a jwt token in the response
                localStorage.setItem('currentUser', JSON.stringify(data));
            // let user = response.json();
            // if (user && user.token) {
            //     console.log("user token >>> ")
            //     // store user details and jwt token in local storage to keep user logged in between page refreshes
            // }
                    console.log("user >>> ",JSON.stringify(data));
                    this.router.navigate(['/home']);
                    
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
