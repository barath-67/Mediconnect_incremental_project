import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Doctor } from "../../models/Doctor";
import { User } from "../../models/User";
import { MediConnectService } from "../../services/mediconnect.service";
import { ActivatedRoute } from "@angular/router";
import { HttpErrorResponse } from "@angular/common/http";

@Component({
    selector: 'doctor-edit',
    templateUrl: './doctoredit.component.html',
    styleUrls: ['./doctoredit.component.scss'],
})
export class DoctorEditComponent {
    doctorForm: FormGroup;
    successMessage: string | null;
    errorMessage: string | null;
    doctorId: number;
    userId: number;
    doctor: Doctor;
    user: User;

    constructor(private fb: FormBuilder, private mediService: MediConnectService, private route: ActivatedRoute) { }

    ngOnInit(): void {
        this.initializeForm();
    }
    initializeForm() {
        this.doctorForm = this.fb.group({
            fullName: ['', [Validators.required, Validators.minLength(2)]],
            username: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9]*')]],
            password: ['', [Validators.required, Validators.pattern('^(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$')]],
            specialty: ['', [Validators.required, Validators.minLength(2)]],
            contactNumber: ['', [Validators.required, Validators.pattern('[0-9]*')]],
            email: ['', [Validators.required, Validators.email]],
            yearsOfExperience: ['', [Validators.required, Validators.min(1)]]
        })

        this.doctorId = Number(this.route.snapshot.paramMap.get('doctorId'));
        this.userId = Number(this.route.snapshot.paramMap.get('userId'));
    }

    loadDoctorDetails() {
        this.mediService.getDoctorById(this.doctorId).subscribe((data) => {
            this.doctorForm.patchValue(data);
        })
    }

    onSubmit() {
        if (this.doctorForm.valid) {
            this.mediService.updateDoctor(this.doctorForm.value).subscribe({
                next: (data) => {
                    console.log("Doctor details: ", data.message);
                    this.successMessage = 'Doctor updated successfully!'
                },
                error: (error) => this.handleError(error)
            })
        }
        this.errorMessage = 'Please fill out all the required fields';
        this.successMessage = null;
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