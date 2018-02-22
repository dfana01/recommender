import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ViewController, ToastController } from 'ionic-angular';
import { AuthProvider } from '../../providers/auth/auth';
import { Credential } from '../../app/app.model';

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  credential: Credential = {} as Credential;

  constructor(private viewCtrl: ViewController, private authProvider: AuthProvider,
            private toastCtrl: ToastController) {}

  onLogin(){
    this.authProvider.login(this.credential)
      .subscribe(
        (data) => {
          console.log(data);
        },
        (error) => {
          this.toastCtrl.create({ duration: 3000, message: "Invalid user or password."})
          console.log(error);
        }
      );
  }

}
