import { TestBed } from '@angular/core/testing';

import { RefereeService } from './referee.service';

describe('RefereeService', () => {
  let service: RefereeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RefereeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
