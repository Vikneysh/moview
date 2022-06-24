import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Md5 } from 'ts-md5/dist/md5';
import { LoginstatusService } from '../loginstatus.service';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  password: string = '';
  email: string = '';
  myobj: any;
  login: any = '';
  btn: string = 'Login';
  check: boolean = false;
  constructor(
    private http: HttpClient,
    private log: LoginstatusService,
    private router: Router,
    private toast: NgToastService
  ) {}

  doLogin(): void {
    this.log.setBtn(this.btn);

    this.myobj = {
      email: this.email,
      password: Md5.hashStr(this.password),
      btn: this.btn,
    };

    this.http
      .post<any>(
        'http://localhost:8080/RestApiServlet/Authentication',
        this.myobj,
        { withCredentials: true }
      )
      .subscribe((data) => {
        console.log(data);
        this.login = data;
        this.log.setLogin(data);
        console.log(this.log.getLogin());
        if (this.log.getLogin() != null) {
          this.check = true;
          this.router.navigate(['/userredirect']);
        }
        if (this.check == false) {
          window.alert('Invalid');
          this.toast.info({
            detail: 'Login Failed',
            summary: 'Incorrect credentials! Please try again',
            duration: 2000,
          });
        }
        // this.log.setStatus('Welcome ' + this.login.name);
        // this.log.setBtn('Logout');
      });
  }
  ngOnInit(): void {}
}
