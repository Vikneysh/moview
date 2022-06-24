import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ClickedMovieService {
  clickedMovie: string;

  constructor() {}
  setId(data: any) {
    this.clickedMovie = data;
    console.log(data);
  }

  getId() {
    return this.clickedMovie;
  }
}
