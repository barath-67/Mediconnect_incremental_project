import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-clinic-create',
  templateUrl: './cliniccreate.component.html',
  styleUrls: ['./cliniccreate.component.scss']
})
export class ClinicCreateComponent implements OnInit {
  clinicForm!: FormGroup;
  submitted = false;
  successMessage = '';
  errorMessage = '';

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.clinicForm = this.formBuilder.group({
      clinicId: [1, [Validators.required, Validators.min(1)]],
      clinicName: ['', [Validators.required, Validators.minLength(2)]],
      location: ['', Validators.required],
      contactNumber: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      establishedYear: ['', [Validators.required, Validators.pattern(/^(19|20)\d{2}$/)]]
    });
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.clinicForm.valid) {
      this.successMessage = 'Clinic has been successfully created!';
      this.errorMessage = '';
      console.log('Clinic Data:', this.clinicForm.value);
      this.clinicForm.reset();
      this.submitted = false;
    } else {
      this.errorMessage = 'Please correct the errors in the form.';
      this.successMessage = '';
    }
  }

  resetForm(): void {
    this.clinicForm.reset();
    this.submitted = false;
    this.successMessage = '';
    this.errorMessage = '';
  }
}