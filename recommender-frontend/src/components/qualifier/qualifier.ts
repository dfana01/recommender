import { Component, OnInit, Input } from '@angular/core';
import { Movie, User, Rate } from '../../app/app.model';
import { RateProvider } from '../../providers/rate/rate';
import { AuthProvider } from '../../providers/auth/auth';
import { ToastController } from 'ionic-angular';

@Component({
  selector: 'qualifier',
  templateUrl: 'qualifier.html'
})
export class QualifierComponent implements OnInit{

  @Input("movie")
  movie : Movie;
  user: User;

  constructor(private userProvider: AuthProvider, private rateProvider: RateProvider, 
            private toastCtrl: ToastController ) {}

  ngOnInit(){
    this.userProvider.watchUser()
      .subscribe((user) => {
        if(user != null){
          this.user = user;
        }
      });
  }

  rate(qualification){
    let rate = {
      qualification: qualification,
      movieId: this.movie.id,
      userId: this.user.id
    } as Rate;

    this.rateProvider.rate(rate)
      .subscribe((rate)=>{
        this.toastCtrl.create({ duration: 3000, message: "Thanks we apreciate your contributtion." }).present(); 
      },(error)=>{
        this.toastCtrl.create({ duration: 3000, message: "You already rating that movie, please select another." }).present();
      });
      
  }

}
