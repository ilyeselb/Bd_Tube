import {Component, Directive, OnInit, Output, Input, EventEmitter} from '@angular/core';
import {Video} from '../Model/video/video';
import {VideoRechercher} from '../Model/videoRechercher/videoRechercher';
import {VideoRechercherService} from '../Model/videoRechercher/video-rechercher.service';
import {Router} from '@angular/router';
import {VideoService} from '../Model/video/video.service';
import {AffichageVideoComponent} from '../affichage-video/affichage-video.component';
import {V} from '@angular/core/src/render3';
import {Chanel} from '../Model/Chanel/Chanel';
import {ChanelService} from '../Model/Chanel/chanel.service';
import {UserService} from '../Model/User/user.service';
import {User} from '../Model/User/User';

@Component({
  selector: 'app-search-vid',
  templateUrl: './search-vid.component.html',
  styleUrls: ['./search-vid.component.css']
})


export class SearchVidComponent implements OnInit {
  videos: Video[];
  filtrage: VideoRechercher[];
  test: number;
  s: String;

  constructor(private  videoService: VideoService,
              private   chanelService: ChanelService,
              private  videoRechercher: VideoRechercherService,
              private  UserService: UserService,
              private router: Router) {
  }
   user : User;
  videoAcccepter: Video[];
  ngOnInit() {

    this.UserService.getuserstatic().subscribe(data => {
      this.user = data;
      if(data.role.toString()==='Admin')
        this.router.navigate(['/demande']);
    });

    this.videoRechercher.filtrage().subscribe(data => {
      this.filtrage = data;
    });
    this.videoService.getAllVideo().subscribe(data => {
      this.videoAcccepter = data;
    });
  }
  logout()
  { this.UserService.Logout().subscribe(data => {
    this.user = data;
    this.router.navigate(['/login']);

  });}
  search(c: string) {
    this.s = c;
    this.videoService.getvid(c).subscribe(data => {
      this.videos = data;
    });
    console.log(this.videos);
  }

  gotoaffiche() {
    this.router.navigate(['/afficher']);
  }

  gotoaffiche2() {
    this.router.navigate(['/affichage']);
  }

  gotolist2() {
    this.router.navigate(['/chanel']);


  }

  save(video: VideoRechercher) {

    console.log(video.description);
    console.log(video.url);
    var elem = null;
    var elem2 = null;
    this.videoRechercher.add(video).subscribe(result => {
      if (confirm('voulez vous faire la demande ')) {

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

  regarder(video: Video) {
    this.videoService.regarder(video).subscribe(result => {
      this.gotoaffiche2();
    });

    console.log('video',video)
  }

  transfere(video: Video) {
    this.videoRechercher.transfere(video).subscribe(result => {
      this.gotoaffiche();
    });
 console.log('video',video)
  }

  videoschanel: Video[];

  search2(c: Chanel) {
    this.videoService.getvid2(c).subscribe(data => {
      this.videoschanel = data;
    });
    let b;
    console.log(this.videos);
    this.gotolist2();
  }

  chan: Chanel;
  chanels: Chanel[];
  checke = false;
  checke2 = false;

  getChanel(id: String) {
    this.chanelService.getChanels(id).subscribe(data => {
      this.chanels = data;
    });
    console.log('coms', this.chanels);

  }


}
