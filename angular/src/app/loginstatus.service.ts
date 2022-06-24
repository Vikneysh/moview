import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginstatusService {
  logBtn: string = 'Login';
  logStat: string = 'Not Logged in';
  login: any;
  uId: any;
  constructor() {}
  setBtn(data: any) {
    this.logBtn = data;
    console.log(data);
  }

  getBtn(): string {
    return this.logBtn;
  }

  setStatus(data: any) {
    this.logStat = data;
    console.log(data);
  }

  getStatus(): string {
    return this.logStat;
  }

  getLogin(): Observable<any> {
    return this.login;
  }

  setLogin(data: any) {
    this.login = data;
    console.log(data);
  }

  setUserId(data: any) {
    this.uId = data;
    console.log(this.uId);
  }

  getUserId() {
    return this.uId;
  }
}
