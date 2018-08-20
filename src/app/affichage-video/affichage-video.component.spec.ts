import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AffichageVideoComponent } from './affichage-video.component';

describe('AffichageVideoComponent', () => {
  let component: AffichageVideoComponent;
  let fixture: ComponentFixture<AffichageVideoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AffichageVideoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AffichageVideoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
