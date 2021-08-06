package com.example.programa.view;

import com.example.programa.controller.AcademicService;
import com.example.programa.model.Academic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/academic")
public class AcademicResource {
    private final AcademicService academicService;

    public AcademicResource(AcademicService academicService){
        this.academicService = academicService;
    }
    @PostMapping("/create")
    public ResponseEntity<Academic> createAcademic(@RequestBody AcademicVO academicVO){
        Academic academic = new Academic();
        academic.setLastName(academicVO.getLastName());
        academic.setAddress(academicVO.getAddress());
        academic.setEmail(academicVO.getEmail());
        academic.setPhone(academicVO.getPhone());
        academic.setBirthDate(LocalDate.parse(academicVO.getBirthDate()));
        academic.setResume(academicVO.getResume());
        academic.setDateOfCreation(LocalDate.now());
        academic.setUpdateDate(LocalDate.now());
        return new ResponseEntity<>(this.academicService.create(academic), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Academic>> findAll(){
        return ResponseEntity.ok(this.academicService.findAll());
    }

    @GetMapping("/{identification}")
    public ResponseEntity<Academic> findById(@PathVariable("identification") int id){
        return academicService.findById(id)
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PutMapping("/update/{identification}")
    public ResponseEntity<Academic> updateAcademic(@PathVariable("identification") int id, @RequestBody AcademicVO academicVO){
        Optional<Academic> academic1 = academicService.findById(id);
        if(academic1.isPresent()){
            Academic academic = academic1.get();
            academic.setLastName(academicVO.getLastName());
            academic.setAddress(academicVO.getAddress());
            academic.setEmail(academicVO.getEmail());
            academic.setPhone(academicVO.getPhone());
            academic.setBirthDate(LocalDate.parse(academicVO.getBirthDate()));
            academic.setResume(academicVO.getResume());
            academic.setUpdateDate(LocalDate.now());
            return new ResponseEntity<>(academicService.update(academic), HttpStatus.OK);
            }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @DeleteMapping("/delete/{identification}")
    public void deleteAcademic(@PathVariable("identification") int id){
        academicService.findById(id).ifPresent(academic -> academicService.delete(academic));

    }




}
