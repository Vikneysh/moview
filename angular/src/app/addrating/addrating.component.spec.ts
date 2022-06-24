import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddratingComponent } from './addrating.component';

describe('AddratingComponent', () => {
  let component: AddratingComponent;
  let fixture: ComponentFixture<AddratingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddratingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddratingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
