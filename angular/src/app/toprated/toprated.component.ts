import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-toprated',
  templateUrl: './toprated.component.html',
  styleUrls: ['./toprated.component.scss'],
})
export class TopratedComponent implements OnInit {
  movies: any;
  data: any;
  http: HttpClient;
  stringJson: any;
  constructor(http: HttpClient) {
    this.http = http;
  }

  postdetail(): void {}

  ngOnInit(): void {
    this.http
      .get('https://imdb-api.com/en/API/Top250Movies/k_2pmo9z8a')
      .subscribe((data) => {
        this.data = data;
        this.movies = this.data.items;
        console.log(this.data.items);
        this.stringJson = JSON.parse(this.data);
      });
  }
}
