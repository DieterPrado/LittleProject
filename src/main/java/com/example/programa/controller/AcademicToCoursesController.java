package com.example.programa.controller;

import com.example.programa.model.Academic;
import com.example.programa.model.AcademicToCourse;
import com.example.programa.model.AcademicToCoursePK;
import com.example.programa.model.Courses;
import com.example.programa.service.AcademicService;
import com.example.programa.service.AcademicToRepositoryService;
import com.example.programa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/api/assign")
public class AcademicToCoursesController {
    @Autowired
    AcademicToRepositoryService academicToRepositoryService;
    @Autowired
    AcademicService academicService;
    @Autowired
    CourseService courseService;

    public AcademicToCoursesController(AcademicToRepositoryService academicToRepositoryService) {
        this.academicToRepositoryService = academicToRepositoryService;
    }

    @PostMapping("/{acaId}/assign/{courId}")
    public ResponseEntity<AcademicToCourse> assign(@PathVariable("acaId") int academicId, @PathVariable("courId") int courseId){
        Academic academic = academicService.findById(academicId).get();
        Courses courses = courseService.findById(courseId).get();
        AcademicToCourse academicToCourse = new AcademicToCourse(academic, courses, 0F, "inProgress");
        academicToCourse.setAcademicToCoursePK(new AcademicToCoursePK(academicId,courseId));
        return new ResponseEntity<>(academicToRepositoryService.save(academicToCourse), HttpStatus.CREATED);
    }

    @PutMapping("/{acaId}/modify/{courId}")
    public ResponseEntity<AcademicToCourse> update(@PathVariable("acaId") int academicId, @PathVariable("courId") int courseId, @RequestBody String status){
        Academic academic = academicService.findById(academicId).get();
        AcademicToCoursePK academicToCoursePK = new AcademicToCoursePK(academicId, courseId);
        for(AcademicToCourse searching:academic.getAcademicCourses()){
            if (searching.getAcademicToCoursePK().equals(academicToCoursePK)){
                searching.setStatus(status);
                return new ResponseEntity<>(academicToRepositoryService.save(searching), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Hola", HttpStatus.OK);
    }
}
