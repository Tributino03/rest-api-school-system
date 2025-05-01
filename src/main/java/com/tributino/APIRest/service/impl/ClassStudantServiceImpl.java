package com.tributino.APIRest.service.impl;

import com.tributino.APIRest.dto.ClassStudantDTO;
import com.tributino.APIRest.model.ClassStudant;
import com.tributino.APIRest.model.School;
import com.tributino.APIRest.model.Studant;
import com.tributino.APIRest.model.Teacher;
import com.tributino.APIRest.repository.ClassStudantRepository;
import com.tributino.APIRest.repository.SchoolRepository;
import com.tributino.APIRest.repository.TeacherRepository;
import com.tributino.APIRest.service.ClassStudantService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassStudantServiceImpl implements ClassStudantService {

    @Autowired
    private ClassStudantRepository classStudantRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public List<Studant> findStudantsByClassId(Long id) {
        ClassStudant turma = classStudantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));
        return turma.getStudantsClass();
    }

    @Override
    public Teacher findTeacherByClassId(Long id) {
        ClassStudant turma = classStudantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));
        return turma.getTeacher();
    }

    @Override
    public void update(Long id, ClassStudant classStudant) {
        ClassStudant existing = classStudantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));

        existing.setGrade(classStudant.getGrade());
        existing.setSchool(classStudant.getSchool());
        existing.setTeacher(classStudant.getTeacher());
        existing.setStudantsClass(classStudant.getStudantsClass());

        classStudantRepository.save(existing);
    }

    @Override
    public ClassStudant findById(Long id) {
        return classStudantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));
    }

    @Override
    @Transactional
    public ClassStudant create(ClassStudantDTO dto) {
        Teacher teacher = teacherRepository.findById(dto.getTeacherCpf())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Teacher not found with cpf: " + dto.getTeacherCpf()));

        School school = schoolRepository.findById(dto.getSchoolCodInep())
                .orElseThrow(() -> new EntityNotFoundException(
                        "School not found with codInep: " + dto.getSchoolCodInep()));

        ClassStudant turma = new ClassStudant();
        turma.setGrade(dto.getGrade());
        turma.setTeacher(teacher);
        turma.setSchool(school);

        return classStudantRepository.save(turma);
    }

}
