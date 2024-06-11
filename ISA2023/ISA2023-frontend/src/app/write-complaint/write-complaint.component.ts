import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { WriteComplaintService } from '../service/write-complaint.service';

@Component({
  selector: 'app-write-complaint',
  templateUrl: './write-complaint.component.html',
  styleUrls: ['./write-complaint.component.css']
})
export class WriteComplaintComponent {

	company: string = ""
	admin: string = ""
	content: string = ""

	 ngOnInit(): void {
  }

 constructor(private complaintService: WriteComplaintService, private router: Router, private toastr: ToastrService) { }
 
 	write()
 	{
		 if(this.company == "")
		 {
			 this.toastr.error("You must select a company you did business with", "Error");
		 }
		 this.complaintService.writeComplaint(this.company,
		 this.admin, this.content);
	}
}
