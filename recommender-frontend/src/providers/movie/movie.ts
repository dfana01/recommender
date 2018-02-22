import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Settings } from '../../app/app.settings';
import { Movie } from '../../app/app.model';
import { Observable } from "rxjs/Observable";

@Injectable()
export class MovieProvider {

  constructor(public http: HttpClient) {}

  getMovies(from:number, to:number): Observable<Movie[]>{
    return this.http.get<Movie[]>(Settings.movieRangeUrl(from,to));
  }
}
