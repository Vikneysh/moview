import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admininbox',
  templateUrl: './admininbox.component.html',
  styleUrls: ['./admininbox.component.scss'],
})
export class AdmininboxComponent implements OnInit {
  msgObj: any;
  num: string;
  mailLink: string;

  MSG_URI: string = 'http://localhost:8080/RestApiServlet/MessageServlet';
  constructor(private http: HttpClient, private router: Router) {}

  composeMail(i: number) {
    this.mailLink =
      'mailto:' +
      this.msgObj[i].email +
      '?subject=Greetings%20from%20Moview!&body=Dear%20' +
      this.msgObj[i].uname;
    console.log(this.mailLink);
    window.location.href = this.mailLink;
  }
  ngOnInit(): void {
    this.http.get(this.MSG_URI).subscribe((data) => {
      this.msgObj = data;
      console.log(data);
      this.num = this.msgObj.length;
    });
  }
}
