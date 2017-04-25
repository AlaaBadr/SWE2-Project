import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { User } from '../_models/index';

@Injectable()
export class UserService {
    url: string = "http://localhost:8080";
    constructor(private http: Http) { }

    register(user: User, identity: string) {
        if (identity == 'Teacher') {
            let headers = new Headers({ 'Content-Type': 'application/json' });
            let options = new RequestOptions({ headers: headers });
            return this.http.post(this.url + '/edugame/register/teacher', user, options).map((response: Response) => response.json());
        } else {
            let headers = new Headers({ 'Content-Type': 'application/json' });
            let options = new RequestOptions({ headers: headers });
            return this.http.post(this.url + '/edugame/register/student', user, options
            ).map((response: Response) => response.json());
        }
    }








    // private helper methods

    /* private jwt() {
         // create authorization header with jwt token
         let currentUser = JSON.parse(localStorage.getItem('currentUser'));
         if (currentUser && currentUser.token) {
             let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
             return new RequestOptions({ headers: headers });
         }
     }*/
}