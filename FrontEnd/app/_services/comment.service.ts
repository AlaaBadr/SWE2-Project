import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Comment } from "../_models";
@Injectable()
export class CommentService {

  constructor(private http: Http) { }
  url = "http://localhost:8080";
  addComment(gamename: string, comment: Comment) {
    debugger;
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(this.url + '/edugame/courses/games/' + gamename + '/comments/addComment', comment, options).map((response: Response) => response.json());
  }

}
