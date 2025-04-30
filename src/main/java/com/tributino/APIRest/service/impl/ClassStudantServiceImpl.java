package com.tributino.APIRest.service.impl;

import com.tributino.APIRest.dto.ClassStudantDTO;
import com.tributino.APIRest.model.ClassStudant;
import com.tributino.APIRest.repository.ClassStudantRepository;
import com.tributino.APIRest.service.ClassStudantService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassStudantServiceImpl implements ClassStudantService {

    @Autowired
    private ClassStudantRepository classStudantRepository;

    @Override
    public Iterable<ClassStudant> fetchAll() {
        return classStudantRepository.findAll();
    }

    @Override
    public void insert(ClassStudant classStudant) {
        classStudantRepository.save(classStudant); // Corrigido: estava usando "ClassStudant" com C maiúsculo (nome da classe, não da variável)
    }

    @Override
    public void update(Long id, ClassStudant classStudant) {
        ClassStudant existing = classStudantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));

        // Atualiza os campos necessários
        existing.setGrade(classStudant.getGrade());
        existing.setSchool(classStudant.getSchool());
        existing.setTeacher(classStudant.getTeacher());
        existing.setStudantsClass(classStudant.getStudantsClass());

        classStudantRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        ClassStudant turma = classStudantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));

        // Desassocia os estudantes da turma
        if (turma.getStudantsClass() != null) {
            turma.getStudantsClass().forEach(s -> s.setClassStudant(null));
        }

        // Desassocia o professor da turma
        if (turma.getTeacher() != null) {
            turma.getTeacher().setClassStudant(null);
        }

        classStudantRepository.delete(turma);
    }

    @Override
    public ClassStudant findById(Long id) {
        return classStudantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));
    }

    @Override
    public ClassStudant create(ClassStudantDTO classStudantDTO) {
        // Aqui você pode mapear os dados do DTO para a entidade, se estiver usando DTOs corretamente
        ClassStudant turma = new ClassStudant();
        turma.setGrade(classStudantDTO.getGrade());
        turma.setTeacher(classStudantDTO.getTeacher());
        turma.setSchool(classStudantDTO.getSchool());

        return classStudantRepository.save(turma);
    }
}
