import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncinemasComponent } from './incinemas.component';

describe('IncinemasComponent', () => {
  let component: IncinemasComponent;
  let fixture: ComponentFixture<IncinemasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IncinemasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IncinemasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
