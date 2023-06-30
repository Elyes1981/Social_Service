import { TestBed } from '@angular/core/testing';

import { CustomDatepickerI18nServiceService } from './custom-datepicker-i18n-service.service';

describe('CustomDatepickerI18nServiceService', () => {
  let service: CustomDatepickerI18nServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomDatepickerI18nServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
