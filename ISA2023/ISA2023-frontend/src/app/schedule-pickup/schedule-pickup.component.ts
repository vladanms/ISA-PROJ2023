import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ScheduledPickupDTO } from '../dto/scheduled-pickupDTO';
import { MatTableDataSource } from '@angular/material/table';
import { ScheduledPickupService } from '../service/schedule-pickup.service';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-schedule-pickup',
  templateUrl: './schedule-pickup.component.html',
  styleUrls: ['./schedule-pickup.component.css']
})
export class SchedulePickupComponent {
	
	public scheduleData = new MatTableDataSource<ScheduledPickupDTO>
	public displayedColumns = ['equipment', 'date', 'startTime', 'endTime', 'schedule']
	public scheduledPickups: ScheduledPickupDTO[] = []
	public equipment: string = "";
//	public company = localStorage.getItem('companyName');
	public company: string = JSON.parse(localStorage.getItem('companyName') || '{}')
	public username: string = JSON.parse(localStorage.getItem('currentUser') || '{}')
	
	
	constructor(private router:Router, private toastr: ToastrService, private scheduledPickupService: ScheduledPickupService) { }

  ngOnInit(): void {
	  this.scheduledPickupService.getScheduledPickups(this.company).subscribe(res => {
      this.scheduledPickups = res;
      this.scheduleData.data = this.scheduledPickups;
  		})
	}
	
  public filter()
  {
    this.scheduledPickupService.filter(this.equipment).subscribe(res => {
      this.scheduledPickups = res;
      this.scheduleData.data = this.scheduledPickups;
    })
  }
	
	
	public schedule(id : number)
	{
		this.scheduledPickupService.schedule(id, this.username);
	}
	
public back(){
	localStorage.setItem('companyName', '')
	this.router.navigate(['/homepage-user']);
}
}
