import { TestBed } from '@angular/core/testing';

import { CollaborationStatusService } from './collaboration-status.service';

describe('CollaborationStatusService', () => {
  let service: CollaborationStatusService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CollaborationStatusService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
