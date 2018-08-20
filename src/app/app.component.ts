import { Component } from '@angular/core';
import {Jsonp} from '@angular/http';
import {UserService} from './Model/User/user.service';
import {Router} from '@angular/router';
import {User} from './Model/User/User';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
 user: User;
  title = 'app';
// tslint:disable-next-line:max-line-length
constructor ( private jsonp: Jsonp,
              private UserService:UserService,
              private router: Router) {this.jsonp.request(`http://suggestqueries.google.com/complete/search?client=firefox&q=a&callback=JSONP_CALLBACK`).subscribe(  res => {
      console.log(res.json());
    },
    err => {
      console.log(err);

    });
  this.UserService.getuserstatic().subscribe(data => {
    this.user = data;
    if(data===null)
      this.router.navigate(['/login']);
    console.log('user',this.user);

  });

} }
