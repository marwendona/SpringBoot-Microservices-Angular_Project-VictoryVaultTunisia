import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassementComponent } from './classement.component';

describe('ClassementComponent', () => {
  let component: ClassementComponent;
  let fixture: ComponentFixture<ClassementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClassementComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ClassementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
