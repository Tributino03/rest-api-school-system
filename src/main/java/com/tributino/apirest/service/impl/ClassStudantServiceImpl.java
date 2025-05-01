package com.tributino.apirest.service.impl;

import com.tributino.apirest.dto.ClassStudantDTO;
import com.tributino.apirest.dto.StudantDTO;
import com.tributino.apirest.dto.TeacherDTO;
import com.tributino.apirest.model.ClassStudant;
import com.tributino.apirest.model.School;
import com.tributino.apirest.model.Studant;
import com.tributino.apirest.model.Teacher;
import com.tributino.apirest.repository.ClassStudantRepository;
import com.tributino.apirest.repository.SchoolRepository;
import com.tributino.apirest.repository.TeacherRepository;
import com.tributino.apirest.service.ClassStudantService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassStudantServiceImpl implements ClassStudantService {

    @Autowired
    private ClassStudantRepository classStudantRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public List<StudantDTO> findStudantsByClassId(Long id) {
        ClassStudant turma = classStudantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));

        return turma.getStudantsClass().stream()
                .map(studant -> new StudantDTO(studant))
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO findTeacherByClassId(Long id) {
        ClassStudant turma = classStudantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));
        return new TeacherDTO(turma.getTeacher());
    }


    @Override
    public ClassStudantDTO update(Long id, ClassStudantDTO dto) {
        ClassStudant existing = classStudantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));

        Teacher teacher = teacherRepository.findById(dto.getTeacherCpf())
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));
        School school = schoolRepository.findById(dto.getSchoolCodInep())
                .orElseThrow(() -> new EntityNotFoundException("Escola não encontrada"));

        existing.setTeacher(teacher);
        existing.setSchool(school);
        existing.setGrade(dto.getGrade());

        return new ClassStudantDTO(classStudantRepository.save(existing));
    }


    @Override
    public ClassStudantDTO findById(Long id) {
        ClassStudant turma = classStudantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));
        return new ClassStudantDTO(turma);
    }


    @Override
    @Transactional
    public ClassStudantDTO create(ClassStudantDTO dto) {
        Teacher teacher = teacherRepository.findById(dto.getTeacherCpf())
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));

        School school = schoolRepository.findById(dto.getSchoolCodInep())
                .orElseThrow(() -> new EntityNotFoundException("Escola não encontrada"));

        ClassStudant turma = new ClassStudant();
        turma.setGrade(dto.getGrade());
        turma.setTeacher(teacher);
        turma.setSchool(school);

        return new ClassStudantDTO(classStudantRepository.save(turma));
    }


}
