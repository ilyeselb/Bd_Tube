import {Component, OnInit, Pipe, PipeTransform, Input, Output, ViewChild, AfterViewInit} from '@angular/core';
import {DomSanitizer} from '@angular/platform-browser';
import {Video} from '../Model/video/video';
import {VideoRechercher} from '../Model/VideoRechercher/VideoRechercher';
import {VideoRechercherService} from '../Model/VideoRechercher/video-rechercher.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {VideoService} from '../Model/video/video.service';
import {EventEmitter} from 'events';
import {SearchVidComponent} from '../search-vid/search-vid.component';
import {V} from '@angular/core/src/render3';
import {switchMap} from 'rxjs/operators';
import {ComentsService} from '../Model/Coments/coments.service';
import {Coments} from '../Model/Coments/Coments';
import {Subscription} from 'rxjs';


@Component({
  selector: 'app-affichage-video',
  templateUrl: './affichage-video.component.html',
  styleUrls: ['./affichage-video.component.css']
})
export class AffichageVideoComponent implements OnInit {

  constructor(private  videoRechercher: VideoRechercherService,
              private router: Router,
              private route: ActivatedRoute,
              private videoservice: VideoService,
              private  ComentsService: ComentsService) {
  }
  video : Video;
  video_regarder: Video[];
  url: String;
  coms: Coments[];
 subscription : Subscription;
  ngOnInit(): void {
   this.video_regarder= null;
    this.videoRechercher.transfere2().subscribe(data => {
      this.video_regarder = data;
    });
    console.log('i', this.video_regarder);


  }

  getComents(id: String) {
    this.ComentsService.getComentsr(id).subscribe(data => {
      this.coms = data;
    });
    console.log('coms', this.coms);

  }
}

@Pipe({name: 'safe'})
export class SafePipe implements PipeTransform {
  constructor(private sanitizer: DomSanitizer) {
  }

  transform(url) {
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }
}
