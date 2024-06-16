import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WriteComplaintService {
  apiHost: string = 'http://localhost:8091/';
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
  
  getAdmins(name : string, company : string)
  {
	   return this.http.get<string[]>(this.apiHost + 'scheduledPickup/getAdminsByUserCompany?name=' + name + "?company=" + company, {headers: this.headers});
  }
  
  getCompanies(name : string)
  {
	   return this.http.get<string[]>(this.apiHost + 'scheduledPickup/getCompanyByUser?name=' + name, {headers: this.headers});
  }
	
 }