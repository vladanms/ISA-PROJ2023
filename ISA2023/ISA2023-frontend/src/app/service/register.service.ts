import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
	  apiHost: string = 'http://localhost:8080/';
	  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
	
	  constructor(private http: HttpClient) { }
	  
	  register(username: string, password: string, email: string, name: string, surname: string, gender: string, 
			personalId: string, phone: string, address: string, city: string, country: string): Observable<any> {
		let userDTO = {
		username: username,
		password : password,
		email : email,
		name : name,
		surname : surname,
		gender : gender,
		personalId : personalId,
		phone : phone,
		address : address,
		city : city,
		country : country
		};
		
		return this.http.post<any>(this.apiHost + 'user/register', userDTO, {headers: this.headers});
	
	}
	}