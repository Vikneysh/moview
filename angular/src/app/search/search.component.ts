import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss'],
})
export class SearchComponent implements OnInit {
  data: any;
  listdata: any;
  search: string = '';
  searchClicked: boolean = false;

  ratingsClicked: boolean = false;
  searchObj: any;
  constructor(private http: HttpClient) {}

  populateList(): void {
    this.searchObj = { searchStr: this.search };
    this.searchClicked = true;
    this.http
      .post<any>(
        'http://localhost:8080/RestApiServlet/SearchServlet',
        this.searchObj
      )
      .subscribe((data) => {
        this.listdata = data;
      });
  }
  searchMovie(): void {
    if (this.search == '') {
      window.alert('Please enter a title to search');
    }
    this.searchObj = { searchStr: this.search };
    this.searchClicked = true;
    this.http
      .post<any>(
        'http://localhost:8080/RestApiServlet/SearchServlet',
        this.searchObj
      )
      .subscribe((data) => {
        this.data = data;
        console.log(data[1].title);
      });
  }
  ngOnInit(): void {}
}
