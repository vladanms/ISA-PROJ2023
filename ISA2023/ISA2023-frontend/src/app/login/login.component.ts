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
          },
          error: (e) => {
			  this.toastr.error("Invalid credentials", "Error");
          }
      });
}
