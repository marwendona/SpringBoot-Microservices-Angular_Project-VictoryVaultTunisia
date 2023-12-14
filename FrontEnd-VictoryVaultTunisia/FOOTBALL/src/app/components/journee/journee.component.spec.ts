import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JourneeComponent } from './journee.component';

describe('JourneeComponent', () => {
  let component: JourneeComponent;
  let fixture: ComponentFixture<JourneeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JourneeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(JourneeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
