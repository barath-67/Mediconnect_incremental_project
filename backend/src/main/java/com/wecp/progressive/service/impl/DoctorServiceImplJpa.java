package com.wecp.progressive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Doctor;
import com.wecp.progressive.repository.DoctorRepository;
import com.wecp.progressive.service.DoctorService;

@Service
public class DoctorServiceImplJpa implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    
    public DoctorServiceImplJpa() {
    }
    
    public DoctorServiceImplJpa(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteDoctor(int doctorId) {
        // TODO Auto-generated method stub
        DoctorService.super.deleteDoctor(doctorId);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        // TODO Auto-generated method stub
        return DoctorService.super.getDoctorById(doctorId);
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        // TODO Auto-generated method stub
        DoctorService.super.updateDoctor(doctor);
    }

    
    
}