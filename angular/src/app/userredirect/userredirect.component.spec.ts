import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserredirectComponent } from './userredirect.component';

describe('UserredirectComponent', () => {
  let component: UserredirectComponent;
  let fixture: ComponentFixture<UserredirectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserredirectComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserredirectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
