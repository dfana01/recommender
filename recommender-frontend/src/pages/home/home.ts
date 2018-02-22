import { Component, ViewChild, OnInit } from '@angular/core';
import { NavController, ModalController } from 'ionic-angular';
import { LoginPage } from '../login/login';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage implements OnInit{

  constructor(private navCtrl: NavController, private modalCtrl: ModalController) {}

  ngOnInit(){
    this.modalCtrl.create(LoginPage,{},{
      showBackdrop: false,
      enableBackdropDismiss: false
    }).present();
  }
 
}
