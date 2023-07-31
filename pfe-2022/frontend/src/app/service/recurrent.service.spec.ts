import { TestBed } from '@angular/core/testing';

import { RecurrentService } from './recurrent.service';

describe('RecurrentService', () => {
  let service: RecurrentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecurrentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
