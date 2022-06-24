import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApireqService } from '../apireq.service';
import { MyDetailInterface } from '../my-detail-interface';
import { Router } from '@angular/router';
import { ClickedblogService } from '../clickedblog.service';

@Component({
  selector: 'app-incinemas',
  templateUrl: './incinemas.component.html',
  styleUrls: ['./incinemas.component.scss'],
})
export class IncinemasComponent implements OnInit {
  blog: any;
  users: MyDetailInterface[];
  http: HttpClient;
  constructor(
    private apireq: ApireqService,
    private router: Router,
    private click: ClickedblogService
  ) {}

  viewBlog(id: any): void {
    this.click.setId(id + 1);
    console.log(id + 1);
    this.router.navigate(['/blog']);
  }
  addBlog(): void {
    this.router.navigate(['/addrating']);
  }
  ngOnInit(): void {
    this.blog = this.apireq.getBlogDetail().subscribe((data) => {
      this.blog = data;
      console.log(this.blog);
    });
  }
}
