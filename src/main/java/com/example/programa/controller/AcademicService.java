package com.example.programa.controller;

import com.example.programa.model.Academic;
import com.example.programa.model.repository.AcademicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AcademicService {
    public AcademicRepository academicRepository;

    public AcademicService(AcademicRepository academicRepository){
        this.academicRepository = academicRepository;
    }

    @Transactional
    public Academic create(Academic academic){
        return this.academicRepository.save(academic);
    }

    @Transactional
    public Academic update(Academic academic){
        return this.academicRepository.save(academic);
    }

    @Transactional
    public void delete(Academic academic){
        academicRepository.delete(academic);
    }

    public Optional<Academic> findById(int id){
        return this.academicRepository.findById(id);
    }

    public List<Academic> findAll(){
        return this.academicRepository.findAll();
    }
}
