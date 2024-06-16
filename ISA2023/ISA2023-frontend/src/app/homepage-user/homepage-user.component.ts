import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CompanyDTO } from '../dto/companyDTO';
import { MatTableDataSource } from '@angular/material/table';
import { HomepageUserService } from '../service/homepage-user.service';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-homepage-user',
  templateUrl: './homepage-user.component.html',
  styleUrls: ['./homepage-user.component.css']
})
export class HomepageUserComponent implements OnInit {


	public companyData = new MatTableDataSource<CompanyDTO>
	public displayedColumns = ['name', 'address', 'view']
	public companies: CompanyDTO[] = []
	public name: string = "";
	
  constructor(private router:Router, private toastr: ToastrService, private homepageUserService: HomepageUserService) { }

	
  ngOnInit(): void {
	  this.homepageUserService.getCompanies().subscribe(res => {
      this.companies = res;
      this.companyData.data = this.companies;
  		})
	}
  public filter()
  {
    this.homepageUserService.filter(this.name).subscribe(res => {
      this.companies = res;
      this.companyData.data = this.companies;
    })
  }
  
  public view(company : string)
  {
	  localStorage.setItem('companyName', company);
	  this.router.navigate(['/schedule-pickup']);
  }
  
  public mySchedules()
  {
	  this.router.navigate(['/user-schedule']);
  }
  
    public logout()
  {
	  localStorage.setItem('companyName', '');
	  localStorage.setItem('currentUser', '');
	  localStorage.setItem('currentUserType', '');
	  this.router.navigate(['/login']);
  }
	
}
