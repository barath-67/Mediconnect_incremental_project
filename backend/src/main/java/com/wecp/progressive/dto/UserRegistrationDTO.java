package com.wecp.progressive.dto;

import java.util.Date;

public class UserRegistrationDTO {
    private String username;
    private String password;
    private String role;
    private String fullName;
    private String contactNumber;
    private String email;
    private String address;
    private Date dateOfBirth;
    private String specialty;
    private Integer yearsOfExperience;
    
    public UserRegistrationDTO() {
    }
    
    public UserRegistrationDTO(String username, String password, String role, 
                              String fullName, String contactNumber, String email, 
                              String address, Date dateOfBirth, String specialty, 
                              Integer yearsOfExperience) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.specialty = specialty;
        this.yearsOfExperience = yearsOfExperience;
    }
    
    // Getters and Setters
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getContactNumber() {
        return contactNumber;
    }
    
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getSpecialty() {
        return specialty;
    }
    
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    
    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
