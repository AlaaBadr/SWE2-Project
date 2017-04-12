import { Http } from 'angular2/http';
import 'rxjs/add/operator/map';
import {Injectable} from 'angular2/core';
@Injectable()
export class registerservice {
    constructor(private _http: Http) {

    }
    senddata() {

        return this._http.get("http://localhost:8080/register/student").map(res => res.json());
    }
    createstudent(student)
    {
        return this._http.post("http://localhost:8080/register/student",JSON.stringify(student)).map(res => res.json());

    }
}