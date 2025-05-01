package com.tributino.apirest.service.impl;

import com.tributino.apirest.dto.ClassStudantDTO;
import com.tributino.apirest.dto.SchoolDTO;
import com.tributino.apirest.dto.StudantDTO;
import com.tributino.apirest.dto.TeacherDTO;
import com.tributino.apirest.model.*;
import com.tributino.apirest.repository.SchoolRepository;
import com.tributino.apirest.service.SchoolService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public List<StudantDTO> findStudantsBySchoolId(String codInep) {
        School school = schoolRepository.findById(codInep)
                .orElseThrow(() -> new EntityNotFoundException("School not found"));
        return school.getStudantsSchool().stream()
                .map(StudantDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<TeacherDTO> findTeacherBySchoolId(String codInep) {
        School school = schoolRepository.findById(codInep)
                .orElseThrow(() -> new EntityNotFoundException("School not found"));
        return school.getTeachers().stream()
                .map(TeacherDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClassStudantDTO> findClassBySchoolId(String codInep) {
        School school = schoolRepository.findById(codInep)
                .orElseThrow(() -> new EntityNotFoundException("School not found"));
        return school.getClassStudants().stream()
                .map(classStudant -> new ClassStudantDTO(classStudant))
                .collect(Collectors.toList());
    }

    @Override
    public SchoolDTO FindById(String codInep) {
        School school = schoolRepository.findById(codInep)
                .orElseThrow(() -> new EntityNotFoundException("School not found"));
        return new SchoolDTO(school);
    }

    @Override
    public SchoolDTO create(SchoolDTO schoolDTO) {
        if (schoolRepository.count() > 0) {
            throw new IllegalStateException("Já existe uma escola cadastrada.");
        }
        School school = new School();
        Endereco endereco = new Endereco();
        endereco.setCep(schoolDTO.getCep());
        school.setCodInep(schoolDTO.getCodInep());
        school.setName(schoolDTO.getName());
        school.setEndereco(endereco);
        school = schoolRepository.save(school);
        return new SchoolDTO(schoolRepository.save(school));  // Retornando DTO
    }
}
