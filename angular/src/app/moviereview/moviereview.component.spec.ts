import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoviereviewComponent } from './moviereview.component';

describe('MoviereviewComponent', () => {
  let component: MoviereviewComponent;
  let fixture: ComponentFixture<MoviereviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoviereviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoviereviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
