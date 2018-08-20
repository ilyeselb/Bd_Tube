import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchVidComponent } from './search-vid.component';

describe('SearchVidComponent', () => {
  let component: SearchVidComponent;
  let fixture: ComponentFixture<SearchVidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchVidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchVidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
