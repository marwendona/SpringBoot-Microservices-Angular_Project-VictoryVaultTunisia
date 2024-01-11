import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LineupComponent } from './lineup.component';

describe('LineupComponent', () => {
  let component: LineupComponent;
  let fixture: ComponentFixture<LineupComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LineupComponent]
    });
    fixture = TestBed.createComponent(LineupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
