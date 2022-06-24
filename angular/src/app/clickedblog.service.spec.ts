import { TestBed } from '@angular/core/testing';

import { ClickedblogService } from './clickedblog.service';

describe('ClickedblogService', () => {
  let service: ClickedblogService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClickedblogService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
