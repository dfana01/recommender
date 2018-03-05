import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/do';
import { User, Recommendation } from '../../app/app.model';
import { Settings } from '../../app/app.settings';
import { MovieProvider } from '../movie/movie';

@Injectable()
export class RecommenderProvider {

  constructor(public http: HttpClient, public movieProvider: MovieProvider) { }

  getRecommendations(user: User): Observable<Recommendation[]> {
    return this.http.get<Recommendation[]>(Settings.recommendationUrl(user.id))
      .map((data) => {
        data.forEach((recommendation) => {
          this.movieProvider.getMovieDetail(recommendation.movie.link.tmdbid)
            .subscribe((detail) => {
              detail.backdrop_path = this.movieProvider.getMovieImageUrl(detail.backdrop_path);
              detail.poster_path = this.movieProvider.getMovieImageUrl(detail.poster_path);
              recommendation.movie.detail = detail;
            });
        });
        return data;
      });
  }

}
