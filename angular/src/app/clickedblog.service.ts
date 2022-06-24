import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ClickedblogService {
  clicked: string;
  messageCount: string;
  constructor() {}
  setId(data: any) {
    this.clicked = data;
    console.log(data);
  }

  getId() {
    return this.clicked;
  }
}
