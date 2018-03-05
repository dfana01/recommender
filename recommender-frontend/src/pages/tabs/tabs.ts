import { Component, OnInit } from '@angular/core';
import { IonicPage, NavController, NavParams, Events, ViewController } from 'ionic-angular';
import { RegisterPage } from '../register/register';
import { LoginPage } from '../login/login';

@IonicPage()
@Component({
  selector: 'page-tabs',
  templateUrl: 'tabs.html',
})
export class TabsPage implements OnInit{

  tab1Root: any = LoginPage;
  tab2Root: any = RegisterPage;

  constructor(private events: Events, private viewCtrl: ViewController) {}

  ngOnInit(){
    this.events.subscribe('tab:close', () => this.viewCtrl.dismiss());
  }


}
