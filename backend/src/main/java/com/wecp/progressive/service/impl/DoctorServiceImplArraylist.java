package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Patient;
import com.wecp.progressive.service.impl.PatientServiceImplArraylist;
import com.wecp.progressive.service.impl.PatientServiceImplJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientServiceImplArraylist patientServiceImplArraylist;

    private final PatientServiceImplJpa patientServiceImplJpa;
    PatientController(PatientServiceImplJpa patientServiceImplJpa) {
        this.patientServiceImplJpa = patientServiceImplJpa;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        try {
            List<Patient> patientList = patientServiceImplJpa.getAllPatients();
            return new ResponseEntity<>(patientList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int patientId) {
        try {
            Patient patient = patientServiceImplJpa.getPatientById(patientId);
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addPatient(@RequestBody Patient patient) {
        try {
            int p = patientServiceImplJpa.addPatient(patient);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<?> updatePatient(@PathVariable int patientId, @RequestBody Patient patient) {
        try {
            // Patient p = patientServiceImplJpa.getPatientById(patientId);
            // if (p == null) {
            // throw new Exception("Patient not found");
            // }
            // patientServiceImplJpa.updatePatient(patient);
            patient.setPatientId(patientId);
            patientServiceImplJpa.updatePatient(patient);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable int patientId) {
        try {
            patientServiceImplJpa.deletePatient(patientId);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Patient>> getAllPatientFromArrayList() {
        // try {
        //     List<Patient> patientList = patientServiceImplArraylist.getAllPatients();
        //     return new ResponseEntity<>(patientList, HttpStatus.OK);
        // } catch (Exception e) {
        //     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        // }
        List<Patient> patientList = patientServiceImplArraylist.getAllPatients();
        return new ResponseEntity<>(patientList, HttpStatus.OK);

    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addPatientToArrayList(@RequestBody Patient patient) {
        // try {
        //     int p = patientServiceImplArraylist.addPatient(patient);
        //     return new ResponseEntity<>(p, HttpStatus.CREATED);
        // } catch (Exception e) {
        //     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        // }
        int p = patientServiceImplArraylist.addPatient(patient);
            return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Patient>> getAllPatientSortedByNameFromArrayList() {
        // try {
        //     List<Patient> tmp = patientServiceImplArraylist.getAllPatientSortedByName();
        //     return new ResponseEntity<>(tmp, HttpStatus.OK);
        // } catch (Exception e) {
        //     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        // }
        List<Patient> tmp = patientServiceImplArraylist.getAllPatientSortedByName();
            return new ResponseEntity<>(tmp, HttpStatus.OK);
    }
}
