import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewComplaintComponent } from './view-complaint.component';

describe('ViewComplaintComponent', () => {
  let component: ViewComplaintComponent;
  let fixture: ComponentFixture<ViewComplaintComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewComplaintComponent]
    });
    fixture = TestBed.createComponent(ViewComplaintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
