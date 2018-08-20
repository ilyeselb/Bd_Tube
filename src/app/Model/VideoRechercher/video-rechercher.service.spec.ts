import { TestBed, inject } from '@angular/core/testing';

import { VideoRechercherService } from './video-rechercher.service';

describe('VideoRechercherService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [VideoRechercherService]
    });
  });

  it('should be created', inject([VideoRechercherService], (service: VideoRechercherService) => {
    expect(service).toBeTruthy();
  }));
});
