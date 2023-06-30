import { TestBed } from '@angular/core/testing';

import { ComplaintypeService } from './complaintype.service';

describe('ComplaintypeService', () => {
  let service: ComplaintypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComplaintypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
