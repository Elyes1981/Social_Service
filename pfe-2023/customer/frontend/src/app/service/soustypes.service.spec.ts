import { TestBed } from '@angular/core/testing';

import { SoustypesService } from './soustypes.service';

describe('SoustypesService', () => {
  let service: SoustypesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SoustypesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
