package com.example.programa.service;

import com.example.programa.model.AcademicToCourse;
import com.example.programa.model.AcademicToCoursePK;
import com.example.programa.repository.AcademicToCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicToRepositoryService {
    @Autowired
    public AcademicToCoursesRepository academicToCoursesRepository;

    public AcademicToRepositoryService(AcademicToCoursesRepository academicToCoursesRepository) {
        this.academicToCoursesRepository = academicToCoursesRepository;
    }

    public AcademicToCourse save(AcademicToCourse academicToCourse ){
        return academicToCoursesRepository.save(academicToCourse);

    }
}
