package com.example.programa.controller;

import com.example.programa.model.Courses;
import com.example.programa.model.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {
    public CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Transactional
    public Courses courseCreate(Courses courses){
        return courseRepository.save(courses);
    }

    @Transactional
    public void courseDelete(Courses courses){
        courseRepository.delete(courses);
    }

    @Transactional
    public Courses courseUpdate(Courses courses){
        return courseRepository.save(courses);
    }

    public Optional<Courses> findById(int id){
        return courseRepository.findById(id);
    }

    public List<Courses> findAll(){
        return courseRepository.findAll();
    }

    public List<Courses> findByLanguage(String language){
        return courseRepository.findByLanguage(language);
    }
}
