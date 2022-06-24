import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MyDetailInterface } from './my-detail-interface';
import { map, catchError } from 'rxjs/operators';

export const BASE_URI: string = 'http://localhost:8080/users';

@Injectable({
  providedIn: 'root',
})
export class ApireqService {
  constructor(private http: HttpClient) {}
  USER_URI: string = 'http://localhost:8080/RestApiServlet/ApiServlet';
  MOVIE_URI: string = 'http://localhost:8080/RestApiServlet/MovieServlet';
  BLOG_URI: string = 'http://localhost:8080/RestApiServlet/BlogServlet';

  getDetail(): Observable<any> {
    return this.http.get(this.USER_URI);
  }
  getMovieDetail(): Observable<any> {
    return this.http.get(this.MOVIE_URI);
  }
  getBlogDetail(): Observable<any> {
    return this.http.get(this.BLOG_URI);
  }
  deleteUser(userid: String): Observable<number> {
    return this.http.delete<number>(this.USER_URI + '/?id=' + userid);
  }

  // addUser(person: MyDetailInterface): Observable<any> {
  //   const headers = { 'content-type': 'application/json' };
  //   const body = JSON.stringify(person);
  //   console.log(body);
  //   return this.http.post(this.USER_URI + 'save', body, { headers: headers });
  // }
}
