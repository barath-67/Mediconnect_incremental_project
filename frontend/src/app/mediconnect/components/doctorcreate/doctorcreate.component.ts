import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-doctor-create',
    templateUrl: './doctorcreate.component.html',
    styleUrls: ['./doctorcreate.component.scss']
})
export class DoctorCreateComponent implements OnInit {
    doctorForm!: FormGroup;
    submitted = false;
    successMessage = '';
    errorMessage = '';

    constructor(private formBuilder: FormBuilder) { }

    ngOnInit(): void {
        this.doctorForm = this.formBuilder.group({
            doctorId: ['', [Validators.required, Validators.min(1)]],
            fullName: ['', [Validators.required, Validators.minLength(2)]],
            specialty: ['', [Validators.required]],
            contactNumber: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
            email: ['', [Validators.required, Validators.email]],
            experience: ['', [Validators.required, Validators.min(1)]]
        });
    }

    onSubmit(): void {
        this.submitted = true;
        if (this.doctorForm.valid) {
            this.successMessage = 'Doctor created successfully!';
            this.errorMessage = '';
            console.log('Doctor Data:', this.doctorForm.value);
            this.doctorForm.reset();
            this.submitted = false;
        } else {
            this.errorMessage = 'Please correct the errors in the form.';
            this.successMessage = '';
        }
    }

    resetForm(): void {
        this.doctorForm.reset();
        this.submitted = false;
        this.successMessage = '';
        this.errorMessage = '';
    }
}