package com.example.programa.repository;

import com.example.programa.model.AcademicToCourse;
import com.example.programa.model.AcademicToCoursePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicToCoursesRepository extends JpaRepository<AcademicToCourse, AcademicToCoursePK> {
}
