import { TestBed } from '@angular/core/testing';

import { CooptedbytypeService } from './cooptedbytype.service';

describe('CooptedbytypeService', () => {
  let service: CooptedbytypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CooptedbytypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
