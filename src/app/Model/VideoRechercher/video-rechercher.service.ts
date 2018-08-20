import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {VideoRechercher} from './VideoRechercher';
import {Video} from '../video/video';

@Injectable({
  providedIn: 'root'
})
export class VideoRechercherService {

  constructor(private http: HttpClient) { }

  public api = '//localhost:8080';
  public vide_demande = '//localhost:8080/demande';
  add(videorechercher: VideoRechercher) {
    return this.http.post(this.api + '/adddemande', videorechercher);
  }
  getAllDemande(): Observable<VideoRechercher[]> {
    return this.http.get<VideoRechercher[]>(this.vide_demande);
  }
  Refuser(video: VideoRechercher) {
    return this.http.post(this.api + '/deletedemande' , video);
  }
  transfere2():Observable<Video[]>  {
    return this.http.get<Video[]>(this.api + '/transfere2');
  }
  transfere(video: Video) {
    return this.http.post(this.api + '/transfere' , video);
  }
  regarder2():Observable<Video[]>  {
    return this.http.get<Video[]>(this.api + '/regarder2');
  }
  filtrage(): Observable<VideoRechercher[]> {
    return this.http.get<VideoRechercher[]>(this.api + '/filtrage' );
  }

}
