import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
 
import { MediConnectRoutingModule } from "./mediconnect-routing.module";
import { ReactiveFormsModule } from "@angular/forms";
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { PatientCreateComponent } from "./components/patientcreate/patientcreate.component";
import { DoctorCreateComponent } from "./components/doctorcreate/doctorcreate.component";
import { ClinicCreateComponent } from "./components/cliniccreate/cliniccreate.component";
import { AppointmentCreateComponent } from "./components/appointment/appointment.component"; 
 
@NgModule({
  declarations: [
    PatientCreateComponent,
    DoctorCreateComponent,
    ClinicCreateComponent,
    AppointmentCreateComponent  
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    MediConnectRoutingModule
  ],
  exports: [
    PatientCreateComponent,
    AppointmentCreateComponent  
  ]
})
export class MediconnectModule {}