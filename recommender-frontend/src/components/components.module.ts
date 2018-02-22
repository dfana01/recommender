import { NgModule } from '@angular/core';
import { QualifierComponent } from './qualifier/qualifier';
import { IonicModule } from 'ionic-angular'; 
import { IonicApp } from 'ionic-angular';
import { MovieSlideComponent } from './movie-slide/movie-slide';

@NgModule({
	declarations: [QualifierComponent,
    MovieSlideComponent],
	imports: [IonicModule.forRoot(QualifierComponent),IonicModule.forRoot(MovieSlideComponent)],
	exports: [QualifierComponent,
    MovieSlideComponent]
})
export class ComponentsModule {}
