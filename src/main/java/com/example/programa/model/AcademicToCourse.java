package com.example.programa.model;

import javax.persistence.*;

@Entity
@Table(name = "academic_to_courses")
public class AcademicToCourse {
    @EmbeddedId
    private AcademicToCoursePK academicToCoursePK;

    @ManyToOne
    @MapsId("academicId")
    @JoinColumn(name = "FK_Academic")
    private Academic academic;

    @ManyToOne
    @MapsId("coursesId")
    @JoinColumn(name = "FK_Course")
    private Courses courses;

    private Float hours;

    private String status;

    public AcademicToCourse(AcademicToCoursePK academicToCoursePK, Academic academic, Courses courses, Float hours, String status) {
        this.academicToCoursePK = academicToCoursePK;
        this.academic = academic;
        this.courses = courses;
        this.hours = hours;
        this.status = status;
    }

    public AcademicToCourse(Academic academic, Courses courses) {
        this.academic = academic;
        this.courses = courses;
    }

    public AcademicToCourse(Academic academic, Courses courses, Float hours, String status) {
        this.academic = academic;
        this.courses = courses;
        this.hours = hours;
        this.status = status;
    }

    public AcademicToCourse() {
    }

    public AcademicToCoursePK getAcademicToCoursePK() {
        return academicToCoursePK;
    }

    public void setAcademicToCoursePK(AcademicToCoursePK academicToCoursePK) {
        this.academicToCoursePK = academicToCoursePK;
    }

    public Academic getAcademic() {
        return academic;
    }

    public void setAcademic(Academic academic) {
        this.academic = academic;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public Float getHours() {
        return hours;
    }

    public void setHours(Float hours) {
        this.hours = hours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
