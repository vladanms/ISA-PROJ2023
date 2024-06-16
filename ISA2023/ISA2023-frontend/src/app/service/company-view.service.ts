import { Injectable } from '@angular/core';
import { CompanyDTO } from '../dto/companyDTO';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompanyViewService {
  apiHost: string = 'http://localhost:8091/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  
  public companyName: string = JSON.parse(localStorage.getItem('companyName') || '{}')
  
  constructor(private http: HttpClient) { }
  

 	
	public getEquipment(): Observable<string[]> {
    return this.http.get<string[]>(this.apiHost + 'company/getEquipment?name=' + this.companyName, {headers: this.headers});
  }
	
	public filter(equipment: string): Observable<string[]> {
    if(equipment.length < 1)
    {equipment = 'null';}
	 return this.http.get<string[]>(this.apiHost + 'company/filterEquipment?name=' + this.companyName + "?equipment=" + equipment, {headers: this.headers});
  }
	
}