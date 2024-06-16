import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ComplaintDTO } from '../dto/complaintDTO';
import { MatTableModule } from '@angular/material/table';
import { MatTableDataSource } from '@angular/material/table';
import { HomepageAdminService } from '../service/homepage-admin.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-homepage-admin',
  templateUrl: './homepage-admin.component.html',
  styleUrls: ['./homepage-admin.component.css']
})
export class HomepageAdminComponent implements OnInit {

	public complaintData = new MatTableDataSource<ComplaintDTO>
	public displayedColumns = ['writer', 'admin', 'time']
	public complaints: ComplaintDTO[] = []
	public writer: string = ""
	public content: string = ""
	public response: string = ""
	public id: number = 0

  constructor(private router:Router, private toastr: ToastrService, private homepageAdminService: HomepageAdminService) { }

    ngOnInit(): void {
	  this.homepageAdminService.getComplaints().subscribe(res => {
      this.complaints = res;
      this.complaintData.data = this.complaints;
  		})
	}
	
	public view(content : string, id: number, writer: string)
	{
		this.content = content;
		this.id = id;
		this.writer = writer;
	}

	public submit()
  	{
		if(this.id != 0)
		{
			this.homepageAdminService.Reply(this.id, this.response);
		}
  	}
  public logout()
  {
	  localStorage.setItem('companyName', '');
	  localStorage.setItem('currentUser', '');
	  localStorage.setItem('currentUserType', '');
	  this.router.navigate(['/login']);
  }
}
