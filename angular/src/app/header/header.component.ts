import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginstatusService } from '../loginstatus.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  login: any;
  status: boolean = false;

  constructor(
    private router: Router,
    public log: LoginstatusService,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.http
      .get('http://localhost:8080/RestApiServlet/Authentication')
      .subscribe((data) => {
        this.login = data;
        console.log(data);
        this.status = true;
        this.log.setUserId(this.login.uId);
      });
  }
  logOut(): void {
    this.router.navigate(['/userredirect']);
  }
}
