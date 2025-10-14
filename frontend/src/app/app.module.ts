import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';  
import { PatientSampleComponent } from './mediconnect/components/patientsample/patientsample.component';
import { DoctorSampleComponent } from './mediconnect/components/doctorsample/doctorsample.component';

@NgModule({
  declarations: [
    AppComponent,
    //PatientSampleComponent, // Add PatientSampleComponent
   // DoctorSampleComponent,  // Add DoctorSampleComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
