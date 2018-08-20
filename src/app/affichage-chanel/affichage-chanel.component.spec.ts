import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AffichageChanelComponent } from './affichage-chanel.component';

describe('AffichageChanelComponent', () => {
  let component: AffichageChanelComponent;
  let fixture: ComponentFixture<AffichageChanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AffichageChanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AffichageChanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
