import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import {  Student } from "../_models/index";

@Injectable()
export class AuthenticationService {
    constructor(private http: Http) { }
    url: string = "http://localhost:8080";
    login(user: any) {
          //debugger;
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.url + '/edugame/login', user,options).map((response: Response) => response.json());
        
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}
//content := "Content-Type" ":" type "/" subtype *(";" parameter)