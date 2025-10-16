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
<<<<<<< HEAD
    successMessage: string | null = null;
    errorMessage: string | null = null;
=======
    successMessage = '';
    errorMessage = '';
>>>>>>> 2bfd2c4ab18885c83bba3ee1d316aa0dfae6073f

    constructor(private formBuilder: FormBuilder) { }

    ngOnInit(): void {
        this.doctorForm = this.formBuilder.group({
<<<<<<< HEAD
            doctorId: [null, [Validators.required, Validators.min(1)]],
=======
            doctorId: ['', [Validators.required, Validators.min(1)]],
>>>>>>> 2bfd2c4ab18885c83bba3ee1d316aa0dfae6073f
            fullName: ['', [Validators.required, Validators.minLength(2)]],
            specialty: ['', [Validators.required]],
            contactNumber: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
            email: ['', [Validators.required, Validators.email]],
<<<<<<< HEAD
            yearsOfExperience: [null, [Validators.required, Validators.min(1)]]
=======
            experience: ['', [Validators.required, Validators.min(1)]]
>>>>>>> 2bfd2c4ab18885c83bba3ee1d316aa0dfae6073f
        });
    }

    onSubmit(): void {
<<<<<<< HEAD
        // this.submitted = true;
        if (this.doctorForm.valid) {
            this.successMessage = 'Doctor has been successfully created!';
            this.errorMessage = null;
            console.log('Doctor Data:', this.doctorForm.value);
            this.doctorForm.reset();
            // this.submitted = false;
        } else {
            this.errorMessage = 'Please fill out all required fields correctly.';
            this.successMessage = null;
=======
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
>>>>>>> 2bfd2c4ab18885c83bba3ee1d316aa0dfae6073f
        }
    }

    resetForm(): void {
<<<<<<< HEAD
        this.doctorForm.reset({
            doctorId: null,
            fullName: '',
            specialty: '',
            contactNumber: '',
            email: '',
            yearsOfExperience: null
        });
        // this.submitted = false;
        // this.successMessage = '';
        // this.errorMessage = '';
=======
        this.doctorForm.reset();
        this.submitted = false;
        this.successMessage = '';
        this.errorMessage = '';
>>>>>>> 2bfd2c4ab18885c83bba3ee1d316aa0dfae6073f
    }
}