import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComplainlistComponent } from './complainlist.component';

describe('ComplainlistComponent', () => {
  let component: ComplainlistComponent;
  let fixture: ComponentFixture<ComplainlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComplainlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComplainlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
