import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailresearchComponent } from './detailresearch.component';

describe('DetailresearchComponent', () => {
  let component: DetailresearchComponent;
  let fixture: ComponentFixture<DetailresearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailresearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailresearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
