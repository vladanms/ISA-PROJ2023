import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ScheduledPickupDTO } from '../dto/scheduled-pickupDTO';
import { MatTableDataSource } from '@angular/material/table';
import { UserScheduleService } from '../service/user-schedule.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-user-schedule',
  templateUrl: './user-schedule.component.html',
  styleUrls: ['./user-schedule.component.css']
})
export class UserScheduleComponent implements OnInit {

public scheduleData = new MatTableDataSource<ScheduledPickupDTO>
	public displayedColumns = ['equipment', 'date', 'startTime', 'endTime', 'schedule']
	public scheduledPickups: ScheduledPickupDTO[] = []
	public equipment: string = "";
//	public company = localStorage.getItem('companyName');
	public company: string = JSON.parse(localStorage.getItem('companyName') || '{}')
	public username: string = JSON.parse(localStorage.getItem('currentUser') || '{}')
	
	
	constructor(private router:Router, private toastr: ToastrService, private userScheduleService: UserScheduleService) { }

  ngOnInit(): void {
	  this.userScheduleService.getScheduledPickups(this.company).subscribe(res => {
      this.scheduledPickups = res;
      this.scheduleData.data = this.scheduledPickups;
  		})
	}
	

	
	public cancel(id : string)
	{
	  this.userScheduleService.cancel(id);
	  this.userScheduleService.getScheduledPickups(this.company).subscribe(res => {
      this.scheduledPickups = res;
      this.scheduleData.data = this.scheduledPickups;
  		})
	}
	
public back(){
	localStorage.setItem('companyName', '')
	this.router.navigate(['/homepage-user']);
}
}
