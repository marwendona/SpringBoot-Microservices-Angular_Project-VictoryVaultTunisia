import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemplacementComponent } from './remplacement.component';

describe('RemplacementComponent', () => {
  let component: RemplacementComponent;
  let fixture: ComponentFixture<RemplacementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RemplacementComponent]
    });
    fixture = TestBed.createComponent(RemplacementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
