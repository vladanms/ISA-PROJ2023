import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WriteComplaintService {
  apiHost: string = 'http://localhost:8080/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  
  constructor(private http: HttpClient) { }


  writeComplaint(company:string, admin:string, content: string)
  {
	  let complaintDTO = {
		username: localStorage.getItem('currentUser'),
		company: company,
		admin: admin,
		content: content,
		response: ""		  
	  }  
	  return this.http.post<any>(this.apiHost + 'complaints/write', complaintDTO, {headers: this.headers});
  }
	
 }