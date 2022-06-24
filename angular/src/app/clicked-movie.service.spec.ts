import { TestBed } from '@angular/core/testing';

import { ClickedMovieService } from './clicked-movie.service';

describe('ClickedMovieService', () => {
  let service: ClickedMovieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClickedMovieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
