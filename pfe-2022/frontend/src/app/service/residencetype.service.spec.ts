import { TestBed } from '@angular/core/testing';

import { ResidencetypeService } from './residencetype.service';

describe('ResidencetypeService', () => {
  let service: ResidencetypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResidencetypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
