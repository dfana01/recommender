import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Settings } from '../../app/app.settings';
import { Movie, MovieDetail } from '../../app/app.model';
import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/do';
@Injectable()
export class MovieProvider {

  constructor(public http: HttpClient) { }

  getMovies(from: number, to: number): Observable<Movie[]> {
    return this.http.get<Movie[]>(Settings.movieRangeUrl(from, to))
      .do((data) => {
        data.forEach((movie) => {
          this.getMovieDetail(movie.link.tmdbid)
            .subscribe((detail) => {
              detail.backdrop_path = this.getMovieImageUrl(detail.backdrop_path);
              detail.poster_path = this.getMovieImageUrl(detail.poster_path);
              movie.detail = detail;
            });
        });
      });
  }

  getMovieDetail(tmdb: number): Observable<MovieDetail> {
    return this.http.get<MovieDetail>(Settings.movieDetailUrl(tmdb));
  }

  getMovieImageUrl(path) {
    return Settings.movieImgUrl(path);
  }
}
