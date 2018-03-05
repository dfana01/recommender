import { Component, OnInit } from '@angular/core';
import { ModalController } from 'ionic-angular';
import { AuthProvider } from '../../providers/auth/auth';
import { RecommenderProvider } from '../../providers/recommender/recommender';
import { Recommendation, User } from '../../app/app.model';
import { TabsPage } from '../tabs/tabs';
import { IntervalObservable } from "rxjs/observable/IntervalObservable";

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage implements OnInit {

  recommendations: Recommendation[] = [];
  user: User;

  constructor(private modalCtrl: ModalController,
    private authProvider: AuthProvider,
    private recommendationProvider: RecommenderProvider) { }

  ngOnInit() {
    IntervalObservable
      .create(5000)
      .subscribe(() => {
        if (this.user != null) {
          this.recommendationProvider
            .getRecommendations(this.user)
            .subscribe((recommendations) => {
              this.recommendations = recommendations ? recommendations : [];
            });
        }
      });

    this.authProvider.watchUser()
      .subscribe((user) => {
        this.user = user;
        if (user == null) {
          this.modalCtrl.create(TabsPage, {}, {
            showBackdrop: false,
            enableBackdropDismiss: false
          }).present();
        }
      });

  }

  logout() {
    this.authProvider.logOut();
  }

}
