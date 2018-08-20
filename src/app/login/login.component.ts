import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../Model/User/user.service';
import {User} from '../Model/User/User';
import { HttpModule } from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Role} from '../Model/User/Account';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private UserService: UserService,
              private router: Router) {
  }

  user: User;
  Accounter: any = {
    username: '',
    password: '',
  };
  ngOnInit() {
  }
  Account: Account;
  Dologin(a: any) {
    console.log('1', a.username);
    console.log('2', a.password);
    this.UserService.add(a.username, a.password).subscribe(data => {
      this.user = data;
    });
    console.log('3', this.user);
      if (this.user.role.toString() === 'Employee') {
        console.log('est admin');

        this.gotoaffiche();
      }
      else
    if (this.user.role.toString() === 'Admin')
    {this.gotoaffiche2();
      console.log('est employee');

    }

  }
  logout()
  { this.UserService.Logout().subscribe(data => {
    this.user = data;
      this.router.navigate(['/login']);

  });}

  gotoaffiche() {
    this.router.navigate(['/']);
  }
  gotoaffiche2() {
    this.router.navigate(['/demande']);
  }

}
