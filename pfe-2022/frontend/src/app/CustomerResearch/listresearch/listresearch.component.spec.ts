import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListresearchComponent } from './listresearch.component';

describe('ListresearchComponent', () => {
  let component: ListresearchComponent;
  let fixture: ComponentFixture<ListresearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListresearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListresearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
