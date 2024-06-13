import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ComplaintDTO } from '../dto/complaintDTO';
import { MatTableDataSource } from '@angular/material/table';
import { ViewComplaintService } from '../service/view-complaint.service';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-view-complaint',
  templateUrl: './view-complaint.component.html',
  styleUrls: ['./view-complaint.component.css']
})
export class ViewComplaintComponent {

public complaintData = new MatTableDataSource<ComplaintDTO>
	public displayedColumns = ['writer', 'admin', 'time']
	public complaints: ComplaintDTO[] = []
	public response: string = ""


  constructor(private router:Router, private toastr: ToastrService, private viewComplaintService: ViewComplaintService) { }

    ngOnInit(): void {
	  this.viewComplaintService.getComplaints().subscribe(res => {
      this.complaints = res;
      this.complaintData.data = this.complaints;
  		})
	}

  public view(response : string)
  {
	  this.response = response;
  }
}
