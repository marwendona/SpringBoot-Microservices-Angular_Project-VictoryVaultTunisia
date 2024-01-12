import { TestBed } from '@angular/core/testing';

import { LineupService } from './lineup.service';

describe('LineupService', () => {
  let service: LineupService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LineupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
