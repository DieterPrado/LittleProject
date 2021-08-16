package com.example.programa.controller;

import com.example.programa.service.CourseService;
import com.example.programa.model.Courses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseResource {
    public CourseService courseService;

    public CourseResource(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping("/create")
    public ResponseEntity<Courses> createCourse(@RequestBody CourseVO courseVO ){
        Courses courses = new Courses();
        courses.setName(courseVO.getName());
        courses.setDescription(courseVO.getDescription());
        courses.setEstimatedDate(courseVO.getEstimatedDate());
        courses.setLanguage(courseVO.getLanguage());
        return new ResponseEntity<>(courseService.courseCreate(courses), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Courses>> findAll(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{language}")
    public ResponseEntity<List<Courses>> findByLanguage(@PathVariable("language") String language){
        return new ResponseEntity<>(courseService.findByLanguage(language), HttpStatus.OK);
    }

    @PutMapping("/update/{identification}")
    public ResponseEntity<Courses> updateCourses(@PathVariable("identification") int id, @RequestBody CourseVO courseVO){
        Optional course1 = courseService.findById(id);
        if(course1.isPresent()){
            Courses courses = new Courses();
            courses.setLanguage(courseVO.getLanguage());
            courses.setDescription(courseVO.getDescription());
            courses.setName(courseVO.getName());
            courses.setEstimatedDate(courseVO.getEstimatedDate());
            return new ResponseEntity<>(courseService.courseUpdate(courses), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
