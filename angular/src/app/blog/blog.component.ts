import { Component, OnInit } from '@angular/core';
import { ClickedblogService } from '../clickedblog.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.scss'],
})
export class BlogComponent implements OnInit {
  blog: any;
  id: string;
  constructor(
    private click: ClickedblogService,
    private http: HttpClient,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.id = this.click.getId();
    console.log(this.id);
    this.http
      .get(
        'http://localhost:8080/RestApiServlet/SingleBlogServlet?id=' + this.id
      )
      .subscribe((data) => {
        this.blog = data;
        console.log(this.blog);
      });
  }
  addBlog(): void {
    this.router.navigate(['/addrating']);
  }
}
