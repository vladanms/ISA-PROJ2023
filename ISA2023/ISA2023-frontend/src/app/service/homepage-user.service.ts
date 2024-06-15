import { Injectable } from '@angular/core';
import { CompanyDTO } from '../dto/companyDTO';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomepageUserService {
  apiHost: string = 'http://localhost:8091/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  
  
  constructor(private http: HttpClient) { }
  
  	public companyName: string = JSON.parse(localStorage.getItem('companyName') || '{}')
  
 	
	public getCompanies(): Observable<CompanyDTO[]> {
    return this.http.get<CompanyDTO[]>(this.apiHost + 'company/getAll', {headers: this.headers});
  }
	
	public filter(equipment: String): Observable<CompanyDTO[]> {
    if(equipment.length < 1)
    {equipment = 'null';}
	 return this.http.get<CompanyDTO[]>(this.apiHost + 'company/getByName?companyName=' + this.companyName, {headers: this.headers});
  }
	
}