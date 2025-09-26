
package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Patient;
import com.wecp.progressive.service.impl.PatientServiceImplArraylist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    @Qualifier("patientServiceImplArraylist")
    private PatientServiceImplArraylist patientServiceImplArraylist;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patientList = patientServiceImplArraylist.getAllPatients();
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int patientId) {
        Patient patient = patientServiceImplArraylist.getPatientById(patientId);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> addPatient(@RequestBody Patient patient) {
        int p = patientServiceImplArraylist.addPatient(patient);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    public ResponseEntity<Void> updatePatient(int patientId, Patient patient) {
        return null;
    }

    public ResponseEntity<Void> deletePatient(int patientId) {
        return null;
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Patient>> getAllPatientFromArrayList() {
        List<Patient> patientList = patientServiceImplArraylist.getAllPatients();
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addPatientToArrayList(@RequestBody Patient patient) {
        int p = patientServiceImplArraylist.addPatient(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Patient>> getAllPatientSortedByNameFromArrayList() {
        List<Patient> tmp = patientServiceImplArraylist.getAllPatientSortedByName();
        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }
}
