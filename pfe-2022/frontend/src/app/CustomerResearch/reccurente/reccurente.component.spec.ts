import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReccurenteComponent } from './reccurente.component';

describe('ReccurenteComponent', () => {
  let component: ReccurenteComponent;
  let fixture: ComponentFixture<ReccurenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReccurenteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReccurenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
