import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { Clinic } from '../../models/Clinic';
import { Patient } from '../../models/Patient';
import { MediConnectService } from '../../services/mediconnect.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
    selector: 'app-appointment',
    templateUrl: './appointment.component.html',
    styleUrls: ['./appointment.component.scss']
})
export class AppointmentCreateComponent implements OnInit {
    appointmentForm!: FormGroup;
    successMessage: string | null = null;
    errorMessage: string | null = null;
    submitted = false;
    clinics: Clinic[];
    selectedPatient: Patient;
    patientId: number;

    constructor(private fb: FormBuilder, private mediService: MediConnectService) { }

    ngOnInit(): void {

        const storedPatientId = localStorage.getItem('patient_id');
        console.log("Patient in LC: ", storedPatientId);
        this.patientId = Number(storedPatientId);

        this.appointmentForm = this.fb.group({
            // appointmentId: [null, [Validators.required, Validators.min(1)]],
            patientId: [this.patientId, [Validators.required, Validators.min(1)]],  //[Validators.required, Validators.min(1)]
            clinic: [null, [Validators.required]],   // , [Validators.required, Validators.min(1)]
            appointmentDate: ['', [Validators.required, this.futureDateValidator]],
            status: ['', [Validators.required]],
            purpose: ['', [Validators.required, Validators.minLength(5)]]
        });

        // this.patientId = Number(localStorage.getItem('patient_id'));
        this.mediService.getPatientById(this.patientId).subscribe((data) => {
            this.selectedPatient = data;
        })
        this.mediService.getAllClinics().subscribe((data) => {
            this.clinics = data;
        })
    }

    // Custom validator for future dates
    private futureDateValidator(control: AbstractControl): { [key: string]: any } | null {
        if (!control.value) return null;
        const selected = new Date(control.value);
        const today = new Date();
        today.setHours(0, 0, 0, 0);
        return selected >= today ? null : { pastDate: true };
    }

    get f() {
        return this.appointmentForm.controls;
    }

    onSubmit(): void {
        console.log("Appointment form isValid? ", this.appointmentForm.valid, this.appointmentForm.value);

        if (this.appointmentForm.valid) {
            this.mediService.createAppointment(this.appointmentForm.value).subscribe({
                next: () => {
                    this.successMessage = `Appointment created successfully!`;
                    this.errorMessage = null;
                },
                error: (error) => this.handleError(error)
            })
            this.resetForm();
        }
        else {
            this.errorMessage = 'Please fill out all required fields correctly.';
            this.successMessage = null;
        }
    }

    resetForm(): void {
        this.appointmentForm.reset({
            appointmentId: null,
            patientId: null,
            clinicId: null,
            appointmentDate: '',
            status: '',
            purpose: ''
        });
    }

    private handleError(error: HttpErrorResponse) {
        if (error.error instanceof ErrorEvent) {
            this.errorMessage = `Client-side error: ${error.error.message}`;
        }
        else {
            this.errorMessage = `Server-side error: ${error.status} ${error.message}`;
            if (error.status === 400) {
                this.errorMessage = 'Bad request. Please check your input.';
            }
        }
        this.successMessage = '';
        console.log('An error occured:', this.errorMessage);
    }
}