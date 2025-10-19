package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Doctor;
import com.wecp.progressive.exception.DoctorAlreadyExistsException;
import com.wecp.progressive.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        try {
            List<Doctor> doctors = doctorService.getAllDoctors();
            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctorId) {
        try {
            Doctor doctor = doctorService.getDoctorById(doctorId);
            if (doctor != null) {
                return new ResponseEntity<>(doctor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addDoctor(@RequestBody Doctor doctor) {
        try {
            Integer doctorId = doctorService.addDoctor(doctor);
            return new ResponseEntity<>(doctorId, HttpStatus.CREATED);
        } catch (DoctorAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<Void> updateDoctor(@PathVariable int doctorId, @RequestBody Doctor doctor) {
        try {
            doctor.setDoctorId(doctorId);
            doctorService.updateDoctor(doctor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int doctorId) {
        try {
            doctorService.deleteDoctor(doctorId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sortedByExperience")
    public ResponseEntity<List<Doctor>> getDoctorSortedByExperience() {
        try {
            List<Doctor> doctors = doctorService.getDoctorSortedByExperience();
            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}