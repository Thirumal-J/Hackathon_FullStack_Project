import { TestBed } from '@angular/core/testing';

import { EventinfoService } from './eventinfo.service';

describe('EventinfoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EventinfoService = TestBed.get(EventinfoService);
    expect(service).toBeTruthy();
  });
});
