import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Notification } from "../_models";
@Injectable()
export class NotificationService {

  constructor(private http: Http) { }
  url = "http://localhost:8080";
  getUserNotifications(username:string){
     let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.get(this.url+'/edugame/notifications/'+username, options).map((response: Response) => response.json());
  }
}
