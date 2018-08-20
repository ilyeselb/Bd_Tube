import {Injectable} from '@angular/core';
import {Coments} from '../Coments/Coments';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Chanel} from './Chanel';
import {Video} from '../video/video';

@Injectable({
  providedIn: 'root'
})
export class ChanelService {

  public api = 'http://localhost:8080/';

  constructor(private http: HttpClient) {
  }

  getChanels(id: String) {
    return this.http.post<Chanel[]>(this.api + '/Getchanel', id);
  }

  transfere3(): Observable<Video[]> {
    return this.http.get<Video[]>(this.api + 'transfere3');
  }
}
