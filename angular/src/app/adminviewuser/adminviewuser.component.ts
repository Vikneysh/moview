import { Component, OnInit } from '@angular/core';
import { ApireqService } from '../apireq.service';
import * as XLSX from 'xlsx';
import { HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-adminviewuser',
  templateUrl: './adminviewuser.component.html',
  styleUrls: ['./adminviewuser.component.scss'],
})
export class AdminviewuserComponent implements OnInit {
  data: any;
  fileName = 'Moview_Users.xlsx';
  num: string;
  constructor(private apireq: ApireqService) {}

  deleteUserById(i: number) {
    let httpheaders = new HttpHeaders().set('Content-type', 'application/Json');
    let options = {
      headers: httpheaders,
    };
    this.apireq.deleteUser(this.data[i].id).subscribe((data) => {});
  }
  exportexcel(): void {
    let element = document.getElementById('users-table');
    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element);

    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Users');

    XLSX.writeFile(wb, this.fileName);
  }
  ngOnInit(): void {
    this.apireq.getDetail().subscribe((data) => {
      this.data = data;
      console.log(this.data);
    });
  }
}
