import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreferenceBlacklistComponent } from './preference-blacklist.component';

describe('PreferenceBlacklistComponent', () => {
  let component: PreferenceBlacklistComponent;
  let fixture: ComponentFixture<PreferenceBlacklistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreferenceBlacklistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PreferenceBlacklistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
