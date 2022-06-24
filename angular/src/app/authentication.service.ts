import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  constructor(private http: HttpClient) {}

  getAuthStatus() {}

  loginUser(userObj: any): Observable<any> {
    return this.http.post<any>(
      'http://localhost:8080/RestApiServlet/Authentication',
      userObj
    );
  }
}
