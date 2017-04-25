import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Game ,User} from '../_models/index';

@Injectable()
export class GameService {
    constructor(private http: Http) { }
    url="http://localhost:8080";
    
    addgame(teacherUsername:string,courseName:string,game:Game) {
         let headers = new Headers({ 'Content-Type': 'application/json' });
            let options = new RequestOptions({ headers: headers });

        return this.http.post(this.url+'/edugame/courses/'+teacherUsername+'/'+courseName+'/games/addGame',game,options).map((response: Response) => response.json());
    }
    getGamesOfCourse(courseName:string){
         let headers = new Headers({ 'Content-Type': 'application/json' });
            let options = new RequestOptions({ headers: headers });
        return this.http.get(this.url+'/edugame/courses/'+courseName+'/games',options).map((response: Response) => response.json());
    }
    getGames(courseName:string,gameName:string){
         let headers = new Headers({ 'Content-Type': 'application/json' });
            let options = new RequestOptions({ headers: headers });
        return this.http.post(this.url+'/edugame/courses/'+courseName+'/games/'+gameName,courseName,options).map((response: Response) => response.json());
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