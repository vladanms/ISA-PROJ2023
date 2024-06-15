import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TypeAuthorizationGuard } from './guard/type-authorization.guard';
import { HomepageUserComponent } from './homepage-user/homepage-user.component';
import { CompanyViewComponent } from './company-view/company-view.component';
import { UserScheduleComponent } from './user-schedule/user-schedule.component';
import { ReplyComplaintComponent } from './reply-complaint/reply-complaint.component';
import { UserComplaintsComponent } from './user-complaints/user-complaints.component';
import { HomepageAdminComponent } from './homepage-admin/homepage-admin.component';

const routes: Routes = [
	{ path: '/schedule-pickup', component: HomepageUserComponent },
	{ path: '/register', component: HomepageUserComponent },
	{ path: '/login', component: HomepageUserComponent },
	{ path: '/company-view', component: CompanyViewComponent,
	 canActivate: [TypeAuthorizationGuard], data: { requiredRole: 'Registered' } },
	{ path: '/user-schedule', component: UserScheduleComponent,
	 canActivate: [TypeAuthorizationGuard], data: { requiredRole: 'Registered' } },
	{ path: '/user-complaints', component: UserComplaintsComponent,
	 canActivate: [TypeAuthorizationGuard], data: { requiredRole: 'Registered' } },
	{ path: '/reply-complaint', component: ReplyComplaintComponent,
	 canActivate: [TypeAuthorizationGuard], data: { requiredRole: 'Admin' } },
	{ path: '/homepage-admin', component: HomepageAdminComponent,
	 canActivate: [TypeAuthorizationGuard], data: { requiredRole: 'Admin' } }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
