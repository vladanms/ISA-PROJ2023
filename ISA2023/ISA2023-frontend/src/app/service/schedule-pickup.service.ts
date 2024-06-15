import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ScheduledPickupDTO } from '../dto/scheduled-pickupDTO';

@Injectable({
  providedIn: 'root'
})
export class ScheduledPickupService {
	  apiHost: string = 'http://localhost:8091/';
	  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
	  
  constructor(private http: HttpClient) { }	  
	  
getScheduledPickups(company : string): Observable<ScheduledPickupDTO[]>{
	 return this.http.get<ScheduledPickupDTO[]>(this.apiHost + 'scheduledPickup/getByCompany?company=' + company, {headers: this.headers});
	 };
	 

schedule(id:number, username:string):Observable<any> {
    let scheduledPickupMakeDTO = {
      id: id,
      username: username
    }
    return this.http.put<any>(this.apiHost + 'scheduledPickup/schedulePredefined', scheduledPickupMakeDTO, {headers: this.headers});
  }
  
filter(equipment: String): Observable<ScheduledPickupDTO[]> {
    if(equipment.length < 1)
    {equipment = 'null';}
	 return this.http.get<ScheduledPickupDTO[]>(this.apiHost + 'scheduledPickup/getFreeByCompanyEquipment?name=' + name + '?equipment=' + equipment, {headers: this.headers});
  }
}