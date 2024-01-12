import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StadeComponent } from './stade.component';

describe('StadeComponent', () => {
  let component: StadeComponent;
  let fixture: ComponentFixture<StadeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StadeComponent]
    });
    fixture = TestBed.createComponent(StadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
