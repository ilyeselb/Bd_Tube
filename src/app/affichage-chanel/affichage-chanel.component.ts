import { Component, OnInit } from '@angular/core';
import {VideoService} from '../Model/video/video.service';
import {Router} from '@angular/router';
import {Video} from '../Model/video/video';
import {Chanel} from '../Model/Chanel/Chanel';
import {VideoRechercherService} from '../Model/VideoRechercher/video-rechercher.service';
import {ChanelService} from '../Model/Chanel/chanel.service';
import {VideoRechercher} from '../Model/VideoRechercher/VideoRechercher';
import {UserService} from '../Model/User/user.service';
import {User} from '../Model/User/User';

@Component({
  selector: 'app-affichage-chanel',
  templateUrl: './affichage-chanel.component.html',
  styleUrls: ['./affichage-chanel.component.css']
})
export class AffichageChanelComponent implements OnInit {
  videos: Video[];
 filtrage: VideoRechercher[];
  constructor(private videoservice: VideoService,
              private VideoRecherchr: VideoRechercherService,
              private  chanelservice: ChanelService,
              private  UserService: UserService,
              private router: Router) {
  }
  user: User;
 chanel: Chanel;
  ngOnInit() {

    this.VideoRecherchr.filtrage().subscribe(data => {
      this.filtrage = data;
    });
    this.chanelservice.transfere3().subscribe(data => {
      this.videos= data;
    });

  }
  gotoaffiche() {
    this.router.navigate(['/afficher']);
  }




  save(video: VideoRechercher) {

    console.log(video.description);
    console.log(video.url);
    var elem=null;
    var elem2=null;
    this.VideoRecherchr.add(video).subscribe(result => {
      if (confirm("voulez vous faire la demande ")) {

        this.videos = this.videos.filter(u => u.id_video !== video.id_video);

      }

    });

  }

  check(video: Video): number {
    let x;

    function test(videoo: VideoRechercher[]): number {

      videoo.map(value => {

        if (video.id_video === value.id_video) {
          if (value.acceptation == 0)
            x = 0;
          if (value.acceptation == 1)
            x = 1;
          if (value.acceptation == -1)

            x = -1;

        }

      });
      return x;
    }

    if (test(this.filtrage) !== 1) {
      if (test(this.filtrage) !== 0) {
        if (test(this.filtrage) !== -1) {
          return 2;
        }
      }
    }
    return test(this.filtrage);

  }


  transfere(video: Video) {


    this.VideoRecherchr.transfere(video).subscribe(result => {
      this.gotoaffiche();


    });

  }



}
