package com.wecp.progressive.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Patient;
import com.wecp.progressive.repository.PatientRepository;
import com.wecp.progressive.service.PatientService;

@Service
public class PatientServiceImplJpa implements PatientService {
    
    private PatientRepository patientRepository;
    @Autowired
    public PatientServiceImplJpa(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public PatientServiceImplJpa(){}
    Patient findByPatientId(int patientId){
        return patientRepository.findByPatientId(patientId);
    }
    @Override
    public Integer addPatient(Patient patient) {
        // TODO Auto-generated method stub
       return patientRepository.save(patient).getPatientId();
        
    }
    @Override
    public void deletePatient(int patientId) {
        // TODO Auto-generated method stub
        patientRepository.deleteById(patientId);
    }
    @Override
    public List<Patient> getAllPatients() {
        // TODO Auto-generated method stub
        return patientRepository.findAll();
    }
    @Override
    public void updatePatient(Patient patient) {
        // TODO Auto-generated method stub
        patientRepository.save(patient);
    }
    @Override
    public List<Patient> getAllPatientSortedByName() {
        // TODO Auto-generated method stub
        return patientRepository.findAllPatientsSortedByName();

    }
    @Override
    public Patient getPatientById(int patientId) {
        // TODO Auto-generated method stub
        return patientRepository.findByPatientId(patientId);
    }

    



}