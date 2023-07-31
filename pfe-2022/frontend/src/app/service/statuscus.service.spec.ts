import { TestBed } from '@angular/core/testing';

import { StatuscusService } from './statuscus.service';

describe('StatuscusService', () => {
  let service: StatuscusService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StatuscusService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
