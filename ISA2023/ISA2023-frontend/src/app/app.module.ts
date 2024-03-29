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
    EquipmentViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
