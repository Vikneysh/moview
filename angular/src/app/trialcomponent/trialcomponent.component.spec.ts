import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrialcomponentComponent } from './trialcomponent.component';

describe('TrialcomponentComponent', () => {
  let component: TrialcomponentComponent;
  let fixture: ComponentFixture<TrialcomponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrialcomponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrialcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
