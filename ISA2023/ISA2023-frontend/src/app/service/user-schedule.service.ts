import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ScheduledPickupDTO } from '../dto/scheduled-pickupDTO';

@Injectable({
  providedIn: 'root'
})
export class UserScheduleService {
		apiHost: string = 'http://localhost:8080/';
	  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

    constructor(private http: HttpClient) { }	  
	  
getScheduledPickups(company : string): Observable<ScheduledPickupDTO[]>{
	 return this.http.get<ScheduledPickupDTO[]>(this.apiHost + 'scheduledPickup/getByUser?name=' + JSON.stringify(localStorage.getItem('currentUser')), {headers: this.headers});
	 };
	 

cancel(id:string):Observable<any> {
    let scheduledPickupMakeDTO = {
      id: id,
      username: JSON.stringify(localStorage.getItem('currentUser'))
    }
    return this.http.put<any>(this.apiHost + 'scheduledPickup/schedulePredefined', scheduledPickupMakeDTO, {headers: this.headers});
  }
  
}
