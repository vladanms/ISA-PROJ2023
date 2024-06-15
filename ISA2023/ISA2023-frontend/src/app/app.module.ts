import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CompanyViewComponent } from './company-view/company-view.component';
import { SchedulePickupComponent } from './schedule-pickup/schedule-pickup.component';
import { WriteComplaintComponent } from './write-complaint/write-complaint.component';
import { ViewComplaintComponent } from './view-complaint/view-complaint.component';
import { ReplyComplaintComponent } from './reply-complaint/reply-complaint.component';
import { EquipmentViewComponent } from './equipment-view/equipment-view.component';
import { HomepageAdminComponent } from './homepage-admin/homepage-admin.component';
import { HomepageUserComponent } from './homepage-user/homepage-user.component';
import { UserComplaintsComponent } from './user-complaints/user-complaints.component';
import { UserScheduleComponent } from './user-schedule/user-schedule.component';
import { TypeAuthorizationGuard } from './guard/type-authorization.guard';
import { UnauthorizedComponent } from './unauthorized/unauthorized.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    CompanyViewComponent,
    SchedulePickupComponent,
    WriteComplaintComponent,
    ViewComplaintComponent,
    ReplyComplaintComponent,
    EquipmentViewComponent,
    HomepageAdminComponent,
    HomepageUserComponent,
    UserComplaintsComponent,
    UserScheduleComponent,
    UnauthorizedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [TypeAuthorizationGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
