import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { windowWhen } from 'rxjs';

interface ImsgObj {
  uname: string;
  email: string;
  message: string;
}

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent implements OnInit {
  msgObj: ImsgObj = {
    uname: '',
    email: '',
    message: '',
  };
  MSG_URI: string = 'http://localhost:8080/RestApiServlet/MessageServlet';
  constructor(private http: HttpClient) {}
  postMessage(): void {
    if (
      this.msgObj.uname == '' ||
      this.msgObj.email == '' ||
      this.msgObj.message == ''
    ) {
      window.alert('Please fill all fields!');
    } else {
      //no longer needed
      console.log(this.msgObj);
      this.http.post<any>(this.MSG_URI, this.msgObj).subscribe((data) => {});
      window.alert('Message posted successfully!');
      window.location.reload();
    }
  }
  ngOnInit(): void {}
}
