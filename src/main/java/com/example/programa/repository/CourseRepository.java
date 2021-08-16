package com.example.programa.repository;

import com.example.programa.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Courses, Integer> {
    public Optional<Courses> findById(int id);
    public List<Courses> findByLanguage(String language);
}
