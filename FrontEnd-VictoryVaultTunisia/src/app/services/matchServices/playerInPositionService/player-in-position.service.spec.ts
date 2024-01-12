import { TestBed } from '@angular/core/testing';

import { PlayerInPositionService } from './player-in-position.service';

describe('PlayerInPositionService', () => {
  let service: PlayerInPositionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlayerInPositionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
