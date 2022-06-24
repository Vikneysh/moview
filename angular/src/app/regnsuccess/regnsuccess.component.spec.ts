import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegnsuccessComponent } from './regnsuccess.component';

describe('RegnsuccessComponent', () => {
  let component: RegnsuccessComponent;
  let fixture: ComponentFixture<RegnsuccessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegnsuccessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegnsuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
