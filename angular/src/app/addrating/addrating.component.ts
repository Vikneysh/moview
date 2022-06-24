import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addrating',
  templateUrl: './addrating.component.html',
  styleUrls: ['./addrating.component.scss'],
})
export class AddratingComponent implements OnInit {
  title: string = '';
  body: string = '';
  date: string = '';
  myobj: any;

  constructor(private http: HttpClient, private router: Router) {}

  postBlog(): void {
    if (this.title == '' || this.date == '' || this.body == '') {
      window.alert('Please complete your blog before submitting');
    }

    this.myobj = {
      title: this.title,
      body: this.body,
      date: this.date,
    };

    this.http
      .post<any>('http://localhost:8080/RestApiServlet/BlogServlet', this.myobj)
      .subscribe((data) => {});
    window.alert('Blog /Review posted successfully!');
    console.log(this.myobj);
    this.title = '';
    this.body = '';
    this.date = '';
    this.router.navigate(['/blogsuccess']);
  }

  ngOnInit(): void {}
}
