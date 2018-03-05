import { Component } from '@angular/core';
import { IonicPage, ToastController, Events } from 'ionic-angular';
import { AuthProvider } from '../../providers/auth/auth';
import { User } from '../../app/app.model';

@IonicPage()
@Component({
  selector: 'page-register',
  templateUrl: 'register.html',
})
export class RegisterPage {
  
  user: User = {} as User;

  constructor(private authProvider: AuthProvider,private toastCtrl: ToastController,private events: Events) {} 

  onSave(){
    if(!this.user.username  || !this.user.password){
      this.toastCtrl.create({ duration: 3000, message: "Please complete all field."}).present();  
      return;
    }
    this.authProvider.register(this.user)
      .subscribe((user) => {
        this.toastCtrl.create({ duration: 3000, message: "Welcome to the platform."}).present();
        this.close();
      },(error) => {
        this.toastCtrl.create({ duration: 3000, message: "We can't complete the register right now, try again later."}).present();
      })
  }
  
  close(){
    this.events.publish("tab:close");
  }
}
