import { Component, OnInit } from '@angular/core';
import { LoginstatusService } from '../loginstatus.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userredirect',
  templateUrl: './userredirect.component.html',
  styleUrls: ['./userredirect.component.scss'],
})
export class UserredirectComponent implements OnInit {
  log: LoginstatusService;
  data: any;
  constructor(private http: HttpClient, private router: Router) {}
  logText: any;
  logBtn: string = '';
  urlData: string = '';
  ngOnInit(): void {
    this.http
      .get('http://localhost:8080/RestApiServlet/Authentication')
      .subscribe((data) => {
        this.data = data;
        console.log(data);
        if (this.data.name == 'Admin') {
          this.urlData = 'http://localhost:4200/admin';
        }
      });
  }

  logOut() {
    this.http
      .get('http://localhost:8080/RestApiServlet/Logout')
      .subscribe((data) => {});
    this.router.navigate(['/index']);
  }
}
