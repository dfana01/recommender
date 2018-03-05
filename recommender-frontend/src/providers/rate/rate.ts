import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core'; 
import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/do';
import { User, Recommendation, Movie, Rate } from '../../app/app.model';
import { Settings } from '../../app/app.settings';

@Injectable()
export class RateProvider {

  constructor(private http: HttpClient) {}

  rate(rate: Rate): Observable<Rate>{
    return this.http.post<Rate>(Settings.rateUrl(),rate);
  }

}
