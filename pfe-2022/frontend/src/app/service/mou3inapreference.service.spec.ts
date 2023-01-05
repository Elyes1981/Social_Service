import { TestBed } from '@angular/core/testing';

import { Mou3inapreferenceService } from './mou3inapreference.service';

describe('Mou3inapreferenceService', () => {
  let service: Mou3inapreferenceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Mou3inapreferenceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
