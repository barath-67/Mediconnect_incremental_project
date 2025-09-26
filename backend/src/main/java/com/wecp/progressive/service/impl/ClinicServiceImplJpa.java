package com.wecp.progressive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Clinic;
import com.wecp.progressive.repository.ClinicRepository;
import com.wecp.progressive.service.ClinicService;

@Service
public class ClinicServiceImplJpa implements ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    // Default constructor for Spring
    public ClinicServiceImplJpa() {}
    
    // Constructor for testing
    public ClinicServiceImplJpa(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }
    @Override
    public Integer addClinic(Clinic clinic) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteClinic(int clinicId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Clinic> getAllClinicByDoctorId(int doctorId) {
        // TODO Auto-generated method stub
        return ClinicService.super.getAllClinicByDoctorId(doctorId);
    }

    @Override
    public List<Clinic> getAllClinicByLocation(String location) {
        // TODO Auto-generated method stub
        return ClinicService.super.getAllClinicByLocation(location);
    }

    @Override
    public List<Clinic> getAllClinics() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Clinic getClinicById(int clinicId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateClinic(Clinic clinic) {
        // TODO Auto-generated method stub
        
    }

    
}