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

	public company: string = ""
	public admin: string = ""
	public content: string = ""
	public companyData: string[] = [];
	public adminData: string[] = [];
	public user: string = JSON.stringify(localStorage.getItem('currentUser'));

 constructor(private writeComplaintService: WriteComplaintService, private router: Router, private toastr: ToastrService) { }
 
 	 ngOnInit(): void {
	  this.writeComplaintService.getCompanies(this.user).subscribe(res => {
      this.companyData = res;;
  		})
  }
 
 	submit()
 	{
		 if(this.company == "")
		 {
			 this.toastr.error("You must select a company you did business with", "Error");
		 }
		 this.writeComplaintService.writeComplaint(this.company,
		 this.admin, this.content);
	}
	
	getAdmins()
	{
	  this.writeComplaintService.getAdmins(this.user, this.company).subscribe(res => {
      this.adminData = res;;
  		})
	}

	
	cancel()
	{
		this.router.navigate(['/user-homepage']);
	}
}
