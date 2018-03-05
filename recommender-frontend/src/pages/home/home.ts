import { Component, OnInit } from '@angular/core';
import { ModalController } from 'ionic-angular';
import { AuthProvider } from '../../providers/auth/auth';
import { RecommenderProvider } from '../../providers/recommender/recommender';
import { Recommendation } from '../../app/app.model';
import { TabsPage } from '../tabs/tabs';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage implements OnInit {

  recommendations: Recommendation[] = [];

  constructor(private modalCtrl: ModalController,
    private authProvider: AuthProvider, private recommendationProvider: RecommenderProvider) { }

  ngOnInit() {
    this.authProvider.watchUser()
      .subscribe((user) => {
        if (user != null) {
          this.recommendationProvider.getRecommendations(user)
            .subscribe((recommendations) => {
              this.recommendations = recommendations;
            });
        } else {
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
