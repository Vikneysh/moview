import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MyDetailInterface } from '../my-detail-interface';
import { Md5 } from 'ts-md5/dist/md5';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss'],
})
export class SignupComponent implements OnInit {
  username: string = '';
  name: string = '';
  password: string = '';
  cnfrmpassword: string = '';
  dob: string = '';
  postId: any;
  myobj: any;
  person: MyDetailInterface;

  constructor(private http: HttpClient, private router: Router) {}

  postdetail(): void {
    if (
      this.username == '' ||
      this.name == '' ||
      this.password == '' ||
      this.cnfrmpassword == '' ||
      this.dob == ''
    ) {
      window.alert('Please fill all the fields');
    }
    if (this.cnfrmpassword != this.password && this.password != '') {
      window.alert('Passwords do not match');
    }
    this.myobj = {
      email: this.username,
      name: this.name,
      password: Md5.hashStr(this.password),
      dob: this.dob,
    };

    if (this.password == this.cnfrmpassword && this.password != '') {
      this.http
        .post<any>(
          'http://localhost:8080/RestApiServlet/ApiServlet',
          this.myobj
        )
        .subscribe((data) => {});
      window.alert('Registration Successful!');
      console.log(this.myobj);
      this.username = '';
      this.name = '';
      this.password = '';
      this.cnfrmpassword = '';
      this.dob = '';
      this.router.navigate(['/regnsuccess']);
    }
  }
  // myobj:Object;

  ngOnInit(): void {}
}
