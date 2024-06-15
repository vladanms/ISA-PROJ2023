import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ComplaintDTO } from '../dto/complaintDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomepageAdminService {
	  apiHost: string = 'http://localhost:8091/';
	  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
	  
	  constructor(private http: HttpClient) { }
	  
	public getComplaints(): Observable<ComplaintDTO[]> {
    return this.http.get<ComplaintDTO[]>(this.apiHost + 'complaint/getByCompanyAdmin?company=' + localStorage.getItem('currentCompany')
    +'?admin=' + localStorage.getItem('currentUser'), {headers: this.headers});
  }
  
  public Reply(id: number, response: string)
  {
	  let replyDTO = {
		  id : id,
		  response: response,
	  };
	return this.http.post<any>(this.apiHost + 'complaint/reply', replyDTO, {headers: this.headers});
  }
 
}