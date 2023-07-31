import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailmouiinaComponent } from './detailmouiina.component';

describe('DetailmouiinaComponent', () => {
  let component: DetailmouiinaComponent;
  let fixture: ComponentFixture<DetailmouiinaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailmouiinaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailmouiinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
