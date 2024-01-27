import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReplyComplaintComponent } from './reply-complaint.component';

describe('ReplyComplaintComponent', () => {
  let component: ReplyComplaintComponent;
  let fixture: ComponentFixture<ReplyComplaintComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReplyComplaintComponent]
    });
    fixture = TestBed.createComponent(ReplyComplaintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
