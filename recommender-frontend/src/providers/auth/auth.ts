import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Settings } from '../../app/app.settings';
import { Credential, User } from '../../app/app.model';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import 'rxjs/add/operator/map';

@Injectable()
export class AuthProvider {

  private currentUser$ = new BehaviorSubject<User>(null);

  constructor(public http: HttpClient) { }

  login(credential: Credential): Observable<User> {
    return this.http.post<User>(Settings.authUrl(), credential)
      .map((user) => {
        this.currentUser$.next(user);
        return user;
      });
  }

  logOut(){
    this.currentUser$.next(null);
  }

  public watchUser(): Observable<User> {
    return this.currentUser$;
  }

  public getUser(): User {
    return this.currentUser$.getValue();
  }

  public register(user : User): Observable<User>{
    return this.http.put<User>(Settings.authUrl(), user)
    .map((user) => {
      this.currentUser$.next(user);
      return user;
    });
  }

}
