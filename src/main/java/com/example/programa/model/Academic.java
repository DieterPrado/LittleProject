package com.example.programa.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "academics")
public class Academic {
    @Id
    @Column(insertable = false)
    private int id;

    @Column(name = "last_name")
    private String lastName;

    private String phone;

    private String email;

    private String address;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String resume;

    @Column(name = "creation_date")
    private LocalDate dateOfCreation;
    @Column(name = "update_date")
    private LocalDate updateDate;

    @OneToMany(mappedBy = "academic", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AcademicToCourse> academicCourses;

    public Academic(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate date) {
        this.birthDate = date;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public List<AcademicToCourse> getAcademicCourses() {
        return academicCourses;
    }

    public void setAcademicCourses(List<AcademicToCourse> academicCourses) {
        this.academicCourses = academicCourses;
    }
}
