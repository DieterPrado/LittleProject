package com.example.programa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Courses {

    @Id
    @Column(insertable = false)
    private int id;

    private String name;

    private String description;

    private String language;

    @Column(name = "estimated_date")
    private LocalDate estimatedDate;

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AcademicToCourse> academicInCourses;

    public Courses() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(LocalDate estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AcademicToCourse> getAcademicInCourses() {
        return academicInCourses;
    }

    public void setAcademicInCourses(List<AcademicToCourse> academicInCourses) {
        this.academicInCourses = academicInCourses;
    }
}
