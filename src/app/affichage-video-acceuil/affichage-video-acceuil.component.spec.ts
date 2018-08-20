import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AffichageVideoAcceuilComponent } from './affichage-video-acceuil.component';

describe('AffichageVideoAcceuilComponent', () => {
  let component: AffichageVideoAcceuilComponent;
  let fixture: ComponentFixture<AffichageVideoAcceuilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AffichageVideoAcceuilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AffichageVideoAcceuilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
