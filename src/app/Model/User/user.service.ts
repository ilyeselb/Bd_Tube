import { Injectable } from '@angular/core';

import { User } from './User';
import {VideoRechercher} from '../VideoRechercher/VideoRechercher';
import {HttpClient} from '@angular/common/http';
import {Video} from '../video/video';
import {Observable} from 'rxjs';
import {Account} from './Account';
import {Coments} from '../Coments/Coments';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  public api = 'http://localhost:8080/';
  constructor(private http: HttpClient) {
  }
  getAllUser(): Observable<User[]> {
    return this.http.get<User[]>(this.api+'alluser');
  }
  add(username: string, password: string):Observable<User> {
    return this.http.get<User>(this.api + 'DoLogin/'+username+'/'+password);
  }
  addaccount(username: string, password: string, u :User):Observable<User> {
    return this.http.post<User>(this.api + 'addacount/'+username+'/'+password,u);
  }

  getuserstatic():Observable<User> {
    return this.http.get<User>(this.api + 'userstatic');
  }
  Logout():Observable<User> {
    return this.http.get<User>(this.api + 'logout');
  }
}
