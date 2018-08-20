import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { SearchVidComponent } from './search-vid/search-vid.component';
import { HighlightDirective } from './highlight.directive';
import {HttpClientModule} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {VideoService} from './Model/video/video.service';
import {VideoRechercherService} from './Model/VideoRechercher/video-Rechercher.service';
import {JsonpModule} from '@angular/http';
import { TrackComponent } from './track/track.component';
import { AdminComponent } from './admin/admin.component';
import { AffichageVideoComponent,SafePipe } from './affichage-video/affichage-video.component';
import { LoginComponent } from './login/login.component';
import {UserService} from './Model/User/user.service';
import {Http} from '@angular/http';
import {pipe} from 'rxjs';
import { AffichageChanelComponent } from './affichage-chanel/affichage-chanel.component';
import { AffichageVideoAcceuilComponent } from './affichage-video-acceuil/affichage-video-acceuil.component';

const appRoutes = [
  {path: '', redirectTo: 'search/video', pathMatch: 'full'},
  {path: 'search/video', component: SearchVidComponent},
  {path: 'demande', component: AdminComponent },
  {path:'afficher',component: AffichageVideoComponent},
  {path: 'affichage', component: AffichageVideoAcceuilComponent},
  {path:'login',component:LoginComponent},
  {path:'chanel',component:AffichageChanelComponent}
];
@NgModule({

  declarations: [
    AppComponent,
    SearchVidComponent,
    HighlightDirective,
    TrackComponent,
    AdminComponent,
    AffichageVideoComponent,
    SafePipe,
    LoginComponent,
    AffichageChanelComponent,
    AffichageVideoAcceuilComponent,

  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule,
    JsonpModule

  ],
  providers: [VideoService,
    VideoRechercherService,
    UserService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
