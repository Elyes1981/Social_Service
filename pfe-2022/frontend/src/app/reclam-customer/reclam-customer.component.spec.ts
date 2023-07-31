import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReclamCustomerComponent } from './reclam-customer.component';

describe('ReclamCustomerComponent', () => {
  let component: ReclamCustomerComponent;
  let fixture: ComponentFixture<ReclamCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReclamCustomerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReclamCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
