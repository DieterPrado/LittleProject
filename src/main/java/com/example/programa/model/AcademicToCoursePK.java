package com.example.programa.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AcademicToCoursePK implements Serializable {
    @Column(name = "FK_Academic")
    private int academicId;
    @Column(name = "FK_Academic")
    private int coursesId;

    public AcademicToCoursePK(int academicId, int coursesId) {
        this.academicId = academicId;
        this.coursesId = coursesId;
    }

    public AcademicToCoursePK() {
    }

    public int getAcademicId() {
        return academicId;
    }

    public void setAcademicId(int academicId) {
        this.academicId = academicId;
    }

    public int getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(int coursesId) {
        this.coursesId = coursesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AcademicToCoursePK)) return false;
        AcademicToCoursePK that = (AcademicToCoursePK) o;
        return getAcademicId() == that.getAcademicId() && getCoursesId() == that.getCoursesId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcademicId(), getCoursesId());
    }
}
