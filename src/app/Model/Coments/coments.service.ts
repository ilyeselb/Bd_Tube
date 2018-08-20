import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Coments} from './Coments';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ComentsService {
  public api = 'http://localhost:8080/Getcoments/';

  constructor(private http: HttpClient) { }
  getComentsr(id: String): Observable<Coments[]> {
    return this.http.get<Coments[]>(this.api  + id);
  }

}
