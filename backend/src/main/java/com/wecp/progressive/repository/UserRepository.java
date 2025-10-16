package com.wecp.progressive.repository;

import com.wecp.progressive.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    // Finds and returns a User entity based on the provided username
    User findByUsername(String username);
    
    // Deletes a User entity associated with the given patientId
    void deleteByPatientId(int patientId);
    
    // Deletes a User entity associated with the given doctorId
    void deleteByDoctorId(int doctorId);
}
