import {Component, OnInit, Pipe, PipeTransform} from '@angular/core';
import {Coments} from '../Model/Coments/Coments';
import {VideoRechercherService} from '../Model/VideoRechercher/video-rechercher.service';
import {VideoService} from '../Model/video/video.service';
import {Video} from '../Model/video/video';
import {ActivatedRoute, Router} from '@angular/router';
import {DomSanitizer} from '@angular/platform-browser';
import {Subscription} from 'rxjs';
import {ComentsService} from '../Model/Coments/coments.service';
import {UserService} from '../Model/User/user.service';
import {User} from '../Model/User/User';

@Component({
  selector: 'app-affichage-video-acceuil',
  templateUrl: './affichage-video-acceuil.component.html',
  styleUrls: ['./affichage-video-acceuil.component.css']
})
export class AffichageVideoAcceuilComponent implements OnInit {

  constructor(private  videoRechercher: VideoRechercherService,
              private router: Router,
              private route: ActivatedRoute,
              private videoservice: VideoService,
              private  UserService: UserService,
              private  ComentsService: ComentsService) {
  }
  user: User;
  video : Video;
  video_regarder: Video[];
  url: String;
  coms: Coments[];
  subscription : Subscription;
  ngOnInit(): void {
    this.UserService.getuserstatic().subscribe(data => {
      this.user = data;
      if(data.role.toString()==='Admin')
        this.router.navigate(['/demande']);
    });
    this.video_regarder= null;
    this.videoRechercher.regarder2().subscribe(data => {
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



