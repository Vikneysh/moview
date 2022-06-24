import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss'],
})
export class AdminComponent implements OnInit {
  num: string;
  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {}
  logOut() {
    this.http
      .get('http://localhost:8080/RestApiServlet/Logout')
      .subscribe((data) => {});
    this.router.navigate(['/index']);
  }
}
