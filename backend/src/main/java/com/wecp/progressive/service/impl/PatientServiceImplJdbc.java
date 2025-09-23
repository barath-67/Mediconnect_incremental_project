package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wecp.progressive.dao.PatientDAO;
import com.wecp.progressive.entity.Patient;
import com.wecp.progressive.service.PatientService;

public class PatientServiceImplJdbc implements PatientService {

    private PatientDAO patientDAO;

    public PatientServiceImplJdbc(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public Integer addPatient(Patient patient) {
        try {
            Integer id = patientDAO.addPatient(patient);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void deletePatient(int patientId) {
        // TODO Auto-generated method stub
        // PatientService.super.deletePatient(patientId);
        try {
            patientDAO.deletePatient(patientId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void emptyArrayList() {
        // TODO Auto-generated method stub
        // PatientService.super.emptyArrayList();
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        // TODO Auto-generated method stub
        return List.of();
    }

    @Override
    public List<Patient> getAllPatients() {
        // TODO Auto-generated method stub
        
        try {
            List<Patient> list = patientDAO.getAllPatients();
        return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public Patient getPatientById(int patientId) {
        // TODO Auto-generated method stub
        // return PatientService.super.getPatientById(patientId);
        try {
            Patient p = patientDAO.getPatientById(patientId);
        return p;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePatient(Patient patient) {
        // TODO Auto-generated method stub
        // PatientService.super.updatePatient(patient);
        
        try {
            patientDAO.updatePatient(patient);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}