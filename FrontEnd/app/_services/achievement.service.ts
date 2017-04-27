import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Game ,User} from '../_models/index';

@Injectable()
export class achievementService {
    constructor(private http: Http) { }
    url="http://localhost:8080";
    
    showAchievements(studentusername:string){
        return this.http.get(this.url+'/edugame/achievements/'+studentusername).map((response: Response) => response.json());
    }
    addAchievement(username:string,gameName:string,levelno:number){
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.get(this.url + '/edugame/' + username + '/courses/games/' + gameName + '/levels/'+levelno, options).map(function (response) { return response.json(); });
    }
    // private helper methods

    /*private jwt() {
        // create authorization header with jwt token
        let currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if (currentUser && currentUser.token) {
            let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
            return new RequestOptions({ headers: headers });
        }
    }*/
}