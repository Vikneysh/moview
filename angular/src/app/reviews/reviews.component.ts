import { Component, OnInit } from '@angular/core';
import { ApireqService } from '../apireq.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ClickedMovieService } from '../clicked-movie.service';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.scss'],
})
export class ReviewsComponent implements OnInit {
  data: any;
  ratingsClicked: boolean = false;
  constructor(
    private apireq: ApireqService,
    private router: Router,
    private http: HttpClient,
    private mov: ClickedMovieService
  ) {}

  viewReviews(): void {
    this.ratingsClicked = false;
  }
  viewRatings(): void {
    this.ratingsClicked = true;
    this.data = this.apireq.getMovieDetail().subscribe((data) => {
      this.data = data;
      console.log(this.data);
    });
  }
  viewMovie(id: any): void {
    // this.click.setId(id + 1);
    this.mov.setId(id + 1);
    this.router.navigate(['/moviereview']);
  }
  addBlog(): void {
    this.router.navigate(['/addrating']);
  }
  ngOnInit(): void {}
}
