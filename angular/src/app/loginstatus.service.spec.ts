import { TestBed } from '@angular/core/testing';

import { LoginstatusService } from './loginstatus.service';

describe('LoginstatusService', () => {
  let service: LoginstatusService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginstatusService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
