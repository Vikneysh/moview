import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlogsuccessComponent } from './blogsuccess.component';

describe('BlogsuccessComponent', () => {
  let component: BlogsuccessComponent;
  let fixture: ComponentFixture<BlogsuccessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlogsuccessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BlogsuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
