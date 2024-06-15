import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class TypeAuthorizationGuard implements CanActivate {
	
constructor(private router: Router, private toastr: ToastrService) {}	
	
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const requiredType = route.data.requiredType as string;
    
    if(localStorage.getItem('userType') == requiredType)
    return true;
    else
    this.toastr.error("You are not authorized to view this page", "Restricted");
    return false;
  };
  
}
