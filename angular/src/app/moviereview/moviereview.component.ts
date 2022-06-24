import { Component, OnInit, SecurityContext } from '@angular/core';
import { ClickedMovieService } from '../clicked-movie.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { LoginstatusService } from '../loginstatus.service';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-moviereview',
  templateUrl: './moviereview.component.html',
  styleUrls: ['./moviereview.component.scss'],
})
export class MoviereviewComponent implements OnInit {
  movie: any;
  id: string;
  rate: number;
  videoURL: string = '';
  rateClicked: boolean = false;
  ratingSet: boolean = false;
  safeURL: SafeResourceUrl;
  myobj: any;

  constructor(
    private click: ClickedMovieService,
    private http: HttpClient,
    private router: Router,
    private _sanitizer: DomSanitizer,
    private log: LoginstatusService,
    private toast: NgToastService
  ) {}
  ngOnInit(): void {
    this.id = this.click.getId();
    console.log(this.id);
    this.http
      .get('http://localhost:8080/RestApiServlet/ReviewServlet?id=' + this.id)
      .subscribe((data: any) => {
        this.movie = data;
        console.log(data);
        this.videoURL = this.movie[0].trailer;
        this.safeURL = this._sanitizer.bypassSecurityTrustResourceUrl(
          this.videoURL
        );
      });
  }
  rateFor(i: number) {
    this.rateClicked = true;
  }

  saveRating(i: number) {
    this.myobj = {
      movieId: this.movie[i].movieId,
      userId: this.log.getUserId(),
      rating: this.rate,
    };
    console.log(this.myobj);
    this.http
      .post<any>('http://localhost:8080/RestApiServlet/RateServlet', this.myobj)
      .subscribe((data) => {});
    this.toast.info({
      detail: 'Rating',
      summary: 'You have rated this movie with ' + this.rate + ' points',
      duration: 2000,
    });
    setTimeout(() => {
      this.router.navigate(['/thanks']);
    }, 2000);
  }
  rateMovie(i: number) {
    this.ratingSet = true;
    this.rate = i;
  }
  addBlog(): void {
    this.router.navigate(['/addrating']);
  }
}
