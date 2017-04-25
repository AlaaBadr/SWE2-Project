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