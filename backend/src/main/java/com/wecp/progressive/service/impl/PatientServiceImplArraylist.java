package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Patient;
import com.wecp.progressive.service.PatientService;

@Service
public class PatientServiceImplArraylist implements PatientService {

    private static List<Patient> patientList = new ArrayList<>();

    @Override
    public void emptyArrayList(){
        patientList = new ArrayList<>();
    }

    @Override
    public Integer addPatient(Patient patient) {
        patientList.add(patient);
        return patientList.size();
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        // CRITICAL FIX: Create a NEW list to avoid modifying the original
        List<Patient> sortedList = new ArrayList<>(patientList);
        sortedList.sort(Comparator.comparing(Patient::getFullName));
        return sortedList;
    }

    @Override
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientList); // Return a copy to avoid external modifications
    }

    @Override
    public Patient getPatientById(int patientId){
        return patientList.stream()
            .filter(p -> p.getPatientId() == patientId)
            .findFirst()
            .orElse(null);
    }
}