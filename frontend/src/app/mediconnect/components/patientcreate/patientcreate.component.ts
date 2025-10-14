import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-patient-create',
    templateUrl: './patientcreate.component.html',
    styleUrls: ['./patientcreate.component.scss']
})
export class PatientCreateComponent implements OnInit {
    patientForm!: FormGroup;
    submitted = false;
    successMessage = '';
    errorMessage = '';

    constructor(private formBuilder: FormBuilder) { }

    ngOnInit(): void {
        this.initializeForm();
    }

    initializeForm(): void {
        this.patientForm = this.formBuilder.group({
            patientId: [null, [Validators.required, Validators.min(1)]],
            fullName: ['', [Validators.required, Validators.minLength(2)]],
            dateOfBirth: ['', Validators.required],
            contactNumber: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
            email: ['', [Validators.required, Validators.email]],
            address: ['', Validators.required]
        });
    }

    onSubmit(): void {
        this.submitted = true;
        if (this.patientForm.valid) {
            this.successMessage = 'Patient created successfully!';
            this.errorMessage = '';
            console.log('Patient Data:', this.patientForm.value);
            this.patientForm.reset();
            this.submitted = false;
        } else {
            this.errorMessage = 'Please correct the errors in the form.';
            this.successMessage = '';
        }
    }

    resetForm(): void {
        this.patientForm.reset({
            patientId: null,
            fullName: '',
            dateOfBirth: '',
            contactNumber: '',
            email: '',
            address: ''
        });
        this.submitted = false;
        this.successMessage = '';
        this.errorMessage = '';
    }

    // Getters for cleaner template access
    get patientId() {
        return this.patientForm.get('patientId');
    }

    get fullName() {
        return this.patientForm.get('fullName');
    }

    get dateOfBirth() {
        return this.patientForm.get('dateOfBirth');
    }

    get contactNumber() {
        return this.patientForm.get('contactNumber');
    }

    get email() {
        return this.patientForm.get('email');
    }

    get address() {
        return this.patientForm.get('address');
    }
}


















// import { Component } from "@angular/core";
// import { Patient } from "../../models/Patient";

// @Component({
//     selector: 'app-patient-create',
//     templateUrl: './patientcreate.component.html',
//     styleUrls: ['./patientcreate.component.scss']
// })

// export class PatientCreateComponent {
//     message: string = '';
//     successMessage: string | null = null;
//     errorMessage: string | null = null;

//     patient: Patient;

//     constructor() {
//         this.patient = {
//             patientId: 0,
//             fullName: '',
//             dateOfBirth: '',
//             contactNumber: '',
//             email: '',
//             address: ''
//         };
//     }

//     onSubmit(): void {
//         if (this.isFormValid()) {
//             this.successMessage = "Patient has been successfully created!";
//             this.errorMessage = null;
//             console.log('Patient Created: ', this.patient);
//             this.resetForm();
//         } else {
//             this.errorMessage = "Please fill out all required fields correctly.";
//             this.successMessage = null;
//         }
//     }

//     isFormValid(): boolean {
//         const { patientId, fullName, dateOfBirth, contactNumber, email, address } = this.patient
//         if (!this.patient.patientId || this.patient.patientId < 1
//             || !this.patient.fullName || this.patient.fullName.length < 2
//             || !this.patient.dateOfBirth || !this.patient.contactNumber
//             || !/^\d{10}$/.test(this.patient.contactNumber) ||
//             !this.patient.email || !/^\S+@\S+\.\S+$/.test(this.patient.email) ||
//             !this.patient.address || this.patient.address.length < 5) {
//             return false;
//         }
//         return true;

//         //     if (this.patient.patientId < 1) {
//         //         return false;
//         //     }
//         //     if (!this.patient.fullName || this.patient.fullName.length === 0) {
//         //         return false;
//         //     }
//         //     // if (!this.patient.dateOfBirth || this.patient.dateOfBirth.length === 0) {
//         //     //     return false;
//         //     // }
//         //     if (!this.patient.dateOfBirth || isNaN(this.patient.dateOfBirth.getTime())) {
//         //         return false;
//         //     }
//         //     if (!this.patient.contactNumber || this.patient.contactNumber.length === 0 || this.patient.contactNumber.length > 10) {
//         //         return false;
//         //     }
//         //     if (!this.patient.email || this.patient.email.length === 0) {
//         //         return false;
//         //     }
//         //     if (!this.patient.address || this.patient.address.length === 0) {
//         //         return false;
//         //     }
//         //     return true;
//     }

//     resetForm() {
//         this.patient = {
//             patientId: 0,
//             fullName: '',
//             dateOfBirth: '',
//             contactNumber: '',
//             email: '',
//             address: ''
//         };
//     }
// }