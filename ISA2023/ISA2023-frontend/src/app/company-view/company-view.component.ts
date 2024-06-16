import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { CompanyViewService } from '../service/company-view.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-company-view',
  templateUrl: './company-view.component.html',
  styleUrls: ['./company-view.component.css']
})
export class CompanyViewComponent {

	public equipmentData = new MatTableDataSource<String>;
	public displayedColumns = ['equipment', 'view'];
	public companyName: string = JSON.stringify(localStorage.getItem('companyName'));
	public equipments: string[] = [];
	public filter: string = "";
	
	constructor(private router:Router, private toastr: ToastrService, private  companyViewService: CompanyViewService)  { }

	  ngOnInit(): void {
	  this.companyViewService.getEquipment().subscribe(res => {
      this.equipments = res;
      this.equipmentData.data = this.equipments;
  		})
	}

	public View(equipment : string)
	{
		localStorage.setItem('equipment', equipment);
		this.router.navigate(['/schedule-pickup'])
	}
	
	public Filter()
	{
	  this.companyViewService.filter(this.filter).subscribe(res => {
      this.equipments = res;
      this.equipmentData.data = this.equipments;
    })
	}
}
