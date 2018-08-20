import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Video} from './Video';
import {VideoRechercher} from '../VideoRechercher/VideoRechercher';
import {Chanel} from '../Chanel/Chanel';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})

};

@Injectable({
  providedIn: 'root'
})

export class VideoService {


  public api = '//localhost:8080/test';
  public apiAdd = '//localhost:8080';

  constructor(private http: HttpClient) {
  }
  getAllVideo(): Observable<Video[]> {
    return this.http.get<Video[]>(this.apiAdd+'/allvid');
  }

  public getvid(x: String): Observable<Video[]> {
    return this.http.post<Video[]>(this.api, x);
  }
  public getvidbyid(x: String): Observable<Video[]> {
    return this.http.post<Video[]>(this.apiAdd+'/getvidid', x);
  }

  public getvid2(x: Chanel): Observable<Video[]> {
    return this.http.post<Video[]>(this.apiAdd + '/chanel', x);
  }

public  add(id_video: String, video: Video) {
    return this.http.post(this.apiAdd + '/addvideo' + '/' + id_video, video);
  }

  public getvidchanel(chanel: Chanel): Observable<Video[]> {
    return this.http.post<Video[]>(this.api, chanel);
  }

 public  regarder(video: Video):Observable<Video[]> {
    return this.http.post<Video[]>(this.api + '/regarderr' , video);
  }

}
