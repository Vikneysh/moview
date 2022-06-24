import { TestBed } from '@angular/core/testing';

import { ApireqService } from './apireq.service';

describe('ApireqService', () => {
  let service: ApireqService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApireqService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
