import { Component } from '@angular/core';
import { IonicPage, ToastController, Events } from 'ionic-angular';
import { AuthProvider } from '../../providers/auth/auth';
import { Credential } from '../../app/app.model'; 

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  credential: Credential = {} as Credential;

  constructor(private authProvider: AuthProvider,
              private toastCtrl: ToastController,
            private events: Events) { }

  onLogin() {
    this.authProvider.login(this.credential)
      .subscribe(
        (data) =>  this.close(),
        (error) => {
          this.toastCtrl.create({ duration: 3000, message: "Invalid user or password." }).present();
        }
      );
  }

  close(){
    this.events.publish("tab:close");
  }
}
