import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials: string = "";
  password: string = "";
  
    ngOnInit(): void { }

  
  constructor(private loginService: LoginService, private router: Router, private toastr: ToastrService) { }
  
  
  	login()
  	{
	  	 this.loginService.login(this.credentials, this.password).subscribe(
       	 {
         	 next: (res) => {
         	 localStorage.setItem('currentUser', this.credentials);
         	 localStorage.setItem('currentUserType', JSON.stringify(this.loginService.getType()));
         	 
         	 if(localStorage.getItem('currentUserType') == 'admin')
         	 {
				localStorage.setItem('companyName', JSON.stringify(this.loginService.getAdminCompany()));	  
			 }
			 else
			 {
				 localStorage.setItem('companyName', '');
			 }
         	 
         	 this.router.navigate([ '/' + this.loginService.getType() +'-homepage']);
         	 },
         	 error: (e) => {
				  this.toastr.error("Invalid credentials", "Error");
          }
      });
	}	
	
	guestLogin()
  	{
	  	localStorage.setItem('currentUser', "");
	  	localStorage.setItem('currentUserType', "guest")
	 	 this.router.navigate(['/user-homepage']);
  	};
  	
  	register()
  	{
		this.router.navigate(['/register']);
	};
  }
