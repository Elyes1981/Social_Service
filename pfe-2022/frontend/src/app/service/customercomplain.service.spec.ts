import { TestBed } from '@angular/core/testing';

import { CustomercomplainService } from './customercomplain.service';

describe('CustomercomplainService', () => {
  let service: CustomercomplainService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomercomplainService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
