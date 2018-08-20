import { TestBed, inject } from '@angular/core/testing';

import { ComentsService } from './coments.service';

describe('ComentsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ComentsService]
    });
  });

  it('should be created', inject([ComentsService], (service: ComentsService) => {
    expect(service).toBeTruthy();
  }));
});
