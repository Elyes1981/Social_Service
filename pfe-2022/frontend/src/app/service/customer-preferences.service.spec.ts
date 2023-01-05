import { TestBed } from '@angular/core/testing';

import { CustomerPreferencesService } from './customer-preferences.service';

describe('CustomerPreferencesService', () => {
  let service: CustomerPreferencesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerPreferencesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
