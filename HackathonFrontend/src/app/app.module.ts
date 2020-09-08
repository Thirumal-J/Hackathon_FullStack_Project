

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DeregisteredComponent } from './deregistered/deregistered.component';
import { RouterModule, Routes } from '@angular/router';
import { NoParticipationComponent } from './no-participation/no-participation.component';
import { TookPartComponent } from './took-part/took-part.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ReportsComponent } from './reports/reports.component';
import { UploadComponent } from './upload/upload.component';
import { RolesComponent } from './roles/roles.component';
import { HttpClientModule } from '@angular/common/http';
import { EventdetailComponent } from './eventdetail/eventdetail.component'; 
import { ReactiveFormsModule , FormsModule } from '@angular/forms'


const appRoutes: Routes = [
  { path: 'deregistered', component: DeregisteredComponent },
  { path: 'noParticipation', component: NoParticipationComponent },
  { path: 'participated', component: TookPartComponent },
  { path: 'participated/:empId/:eventId', component: TookPartComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  { path: '**', component: DashboardComponent }
];

 

@NgModule({
  declarations: [
    AppComponent,
    DeregisteredComponent,
    NoParticipationComponent,
    TookPartComponent,
    DashboardComponent,
    ReportsComponent,
    UploadComponent,
    RolesComponent,
    EventdetailComponent
  ],
  imports: [RouterModule.forRoot(
    appRoutes,
    { enableTracing: true } // <-- debugging purposes only
  ),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
