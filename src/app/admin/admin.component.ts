import {Component, Input, OnInit} from '@angular/core';
import {VideoRechercher} from '../Model/VideoRechercher/VideoRechercher';
import {VideoRechercherService} from '../Model/VideoRechercher/video-rechercher.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Video} from '../Model/video/video';
import {VideoService} from '../Model/video/video.service';
import {ComentsService} from '../Model/Coments/coments.service';
import {Coments} from '../Model/Coments/Coments';
import {UserService} from '../Model/User/user.service';
import {User} from '../Model/User/User';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  videosDemande: VideoRechercher[];
  constructor(  private  videoRechercher: VideoRechercherService,
                private router: Router,
                private videoservice: VideoService,
                private UserService:UserService
              ) { }
              checkk: boolean
 check: boolean;
  ccheck: boolean;


  checke()
  {if (this.check==false)
    this.check=true;
  else
    this.check=false;
  }
  ur: User;
create(x:User){
    this.ur=x;
  if (this.ccheck==false)
    this.ccheck=true;
  else
    this.ccheck=false;

}

  AddAccount(a: any) {
    console.log('1', a.username);
    console.log('2', a.password);
    this.UserService.addaccount(a.username,a.password,this.ur).subscribe(data => {
      this.user = data;
    });
    window.location.reload();
  }
  Account: any = {
    username: '',
    password: '',
  };

  users: User[];
  ngOnInit() {
    this.ccheck=false;

    this.check=false;
    this.UserService.getuserstatic().subscribe(data => {
      this.user = data;
      if(data.role.toString()==='Employee')
        this.router.navigate(['/search/video']);
    });

    this.videoRechercher.getAllDemande().subscribe(data => {
      this.videosDemande = data;
    });
    this.UserService.getAllUser().subscribe(data => {
      this.users = data;
    });
  }

  gotoList() {
    this.router.navigate(['/demande']);
  }
  save(id_video: String , video: Video) {
    this.videoservice.add(id_video, video).subscribe(result => {

    });

    if(confirm("voulez vous refuser la demande  ")) {

      this.videosDemande = this.videosDemande.filter(u => u.id_video !== video.id_video);

    }

  }
  RefuserDemande(video: VideoRechercher): void {
    this.videoRechercher.Refuser(video)
      .subscribe( data => {
        this.videosDemande = this.videosDemande.filter(u => u !== video);
      });
    if(confirm("voulez vous refuser la demande  ")) {
      this.videosDemande = this.videosDemande.filter(u => u !== video);


    }
  }
  user: User;
  logout()
  { this.UserService.Logout().subscribe(data => {
    this.user = data;
    this.router.navigate(['/login']);

  });}
}
