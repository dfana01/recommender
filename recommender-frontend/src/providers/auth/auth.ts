import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Settings } from '../../app/app.settings';
import { Credential} from '../../app/app.model';

@Injectable()
export class AuthProvider {

  constructor(public http: HttpClient) {}

  login(credential: Credential){
    return this.http.post(Settings.authUrl(),credential);
  }

}
