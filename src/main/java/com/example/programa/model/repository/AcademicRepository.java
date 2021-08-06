package com.example.programa.model.repository;

import com.example.programa.model.Academic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AcademicRepository extends JpaRepository<Academic, Integer> {
    public List<Academic> findByLastName(int id);
    public Optional<Academic> findById(int id);


}
