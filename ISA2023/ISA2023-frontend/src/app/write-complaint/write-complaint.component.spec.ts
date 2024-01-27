import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WriteComplaintComponent } from './write-complaint.component';

describe('WriteComplaintComponent', () => {
  let component: WriteComplaintComponent;
  let fixture: ComponentFixture<WriteComplaintComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WriteComplaintComponent]
    });
    fixture = TestBed.createComponent(WriteComplaintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
