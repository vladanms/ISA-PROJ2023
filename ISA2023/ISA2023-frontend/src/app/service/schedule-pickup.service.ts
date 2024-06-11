import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ScheduledPickupDTO } from '../dto/scheduled-pickupDTO';

@Injectable({
  providedIn: 'root'
})
export class ScheduledPickupService {
	  apiHost: string = 'http://localhost:8080/';
	  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
	  
  constructor(private http: HttpClient) { }	  
	  
getScheduledPickups(company : string): Observable<ScheduledPickupDTO[]>{
	 return this.http.get<ScheduledPickupDTO[]>(this.apiHost + 'scheduledPickup/getByCompany?company=' + company, {headers: this.headers});
	 };

}