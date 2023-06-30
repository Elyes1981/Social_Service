import { TestBed } from '@angular/core/testing';

import { Mou3inaService } from './mou3ina.service';

describe('Mou3inaService', () => {
  let service: Mou3inaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Mou3inaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
