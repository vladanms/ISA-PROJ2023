import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { RegisterService } from '../service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
	
		username: string = "";
		password : string = "";
		email : string = "";
		name : string = "";
		surname : string = "";
		gender : string = "male";
		personalId : string = "";
		phone : string = "";
		address : string = "";
		city : string = "";
		country : string = "";
		
		
  ngOnInit(): void {
  }

 constructor(private registerService: RegisterService, private router: Router, private toastr: ToastrService) { }
 
   submit()
   {
	   if(this.username == "" || this.password == "" || this.email == "" || this.name == "" || this.surname == "" || 
	   this.gender == "" || this.personalId == "" || this.phone == "" || this.address == "" || this.city == "" || this.country == "")
	   {
		   this.toastr.error("Please fill out the full form", "Error");
	   }
		this.registerService.register(this.username,this.password,this.email,this.name,this.surname,
	  	this.gender,this.personalId,this.phone,this.address,this.city,this.country).subscribe(
      {
        next: (res) => 
        {
          this.toastr.success("Succesfully registered", "success");
        },
        error: (e) => 
        {
	     this.toastr.error("Error registering; make sure all required fields are unique", "error");
       }
    	});
	   }

	back()
	{
		this.router.navigate(['/login']);
	}
}
