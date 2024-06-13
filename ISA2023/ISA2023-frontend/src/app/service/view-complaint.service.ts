import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ComplaintDTO } from '../dto/complaintDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ViewComplaintService {
	  apiHost: string = 'http://localhost:8080/';
	  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
	  
	  constructor(private http: HttpClient) { }
	  
	public getComplaints(): Observable<ComplaintDTO[]> {
    return this.http.get<ComplaintDTO[]>(this.apiHost + 'complaint/getByWriter?writer=' + localStorage.getItem('currentUser'), {headers: this.headers});
  }
 
}