import { Component, ViewChild, AfterViewInit,Input } from '@angular/core';
import { Slides } from 'ionic-angular';
import { MovieProvider } from '../../providers/movie/movie'; 
import { Movie } from '../../app/app.model';


@Component({
  selector: 'movie-slide',
  templateUrl: 'movie-slide.html'
})
export class MovieSlideComponent  implements AfterViewInit{

  @ViewChild(Slides) slides: Slides;

  @Input("isrecomendations")
  isrecomendations: boolean = false;

  @Input("title")
  title: string = "Items"
  
  movies : Movie[] = [];
  from: number = 1;
  to: number = 20;
  change: number = 10;
  lastTo: number = 20; 
 

  constructor(private movieProvider: MovieProvider) {}

  ngAfterViewInit(){
    this.load(this.from, this.to);
  }

  forward() {
    this.from = this.to;
    this.to = this.to + this.change;
    this.load(this.from, this.to);
    this.slides.slideNext();
  }

  backward(){
    this.slides.slidePrev();
  }

  load(from: number, to:number){
    this.movieProvider.getMovies(from, to)
    .subscribe((data) => {
      this.movies = this.movies.concat(data);
    });
  } 

}
