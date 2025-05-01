package com.tributino.APIRest.service.impl;

import com.tributino.APIRest.dto.SchoolDTO;
import com.tributino.APIRest.model.*;
import com.tributino.APIRest.repository.SchoolRepository;
import com.tributino.APIRest.service.SchoolService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public List<Studant> findStudantsBySchoolId(String codInep) {
        School studants = schoolRepository.findById(codInep)
                .orElseThrow(() -> new EntityNotFoundException("School not found"));
        return studants.getStudantsSchool();
    }

    @Override
    public List<Teacher> findTeacherBySchoolId(String codInep) {
        School teachers = schoolRepository.findById(codInep)
                .orElseThrow(() -> new EntityNotFoundException("School not found"));
        return teachers.getTeachers();
    }

    @Override
    public List<ClassStudant> findClassBySchoolId(String codInep) {
        School classStudants = schoolRepository.findById(codInep)
                .orElseThrow(() -> new EntityNotFoundException("School not found"));
        return classStudants.getClassStudants();
    }

    @Override
    public void delete(String codInep) {
        School school = schoolRepository.findById(codInep)
                .orElseThrow(() -> new EntityNotFoundException("School not found"));

        if(school.getStudantsSchool() != null){
            school.getStudantsSchool().forEach(s -> s.setSchool(null));
        }

        if(school.getTeachers() != null){
            school.getTeachers().forEach(t -> t.setSchool(null));
        }

        schoolRepository.delete(school);
    }

    @Override
    public School FindById(String codInep) {
        return schoolRepository.findById(codInep)
                .orElseThrow(() -> new EntityNotFoundException("School not found"));
    }

    @Override
    public School create(SchoolDTO schoolDTO) {
        School school = new School();
        Endereco endereco = new Endereco();
        endereco.setCep(schoolDTO.getCep());
        school.setCodInep(schoolDTO.getCodInep());
        school.setName(schoolDTO.getName());
        school.setEndereco(endereco);
        return schoolRepository.save(school);
    }
}
