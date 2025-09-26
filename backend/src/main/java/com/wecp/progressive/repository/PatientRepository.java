package com.wecp.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
        Patient findByPatientId(int patientId);

    @Query("SELECT p FROM Patient p ORDER BY p.name ASC")
    List<Patient> findAllPatientsSortedByName();
    
}