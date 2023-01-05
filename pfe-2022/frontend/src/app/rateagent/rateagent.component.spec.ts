import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RateagentComponent } from './rateagent.component';

describe('RateagentComponent', () => {
  let component: RateagentComponent;
  let fixture: ComponentFixture<RateagentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RateagentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RateagentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
