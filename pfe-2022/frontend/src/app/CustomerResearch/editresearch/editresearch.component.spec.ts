import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditresearchComponent } from './editresearch.component';

describe('EditresearchComponent', () => {
  let component: EditresearchComponent;
  let fixture: ComponentFixture<EditresearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditresearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditresearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
