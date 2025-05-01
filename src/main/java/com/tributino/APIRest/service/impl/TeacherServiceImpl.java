package com.tributino.APIRest.service.impl;

import com.tributino.APIRest.dto.TeacherDTO;
import com.tributino.APIRest.model.*;
import com.tributino.APIRest.repository.EnderecoRepository;
import com.tributino.APIRest.repository.TeacherRepository;
import com.tributino.APIRest.service.TeacherService;
import com.tributino.APIRest.service.ViaCepService;  // Não se esqueça de importar o ViaCepService
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public List<Studant> findStudantsByTeacherId(String cpf) {
        Teacher teacher = teacherRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
        return teacher.getStudents();
    }

    @Override
    public ClassStudant findClassByTeacherId(String cpf) {
        Teacher teacher = teacherRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
        return teacher.getClassStudant();
    }

    @Override
    public School findSchoolByTeacherId(String cpf) {
        Teacher teacher = teacherRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
        return teacher.getSchool();
    }

    @Override
    @Transactional
    public void update(String cpf, TeacherDTO dto) {
        Teacher teacher = teacherRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));

        Endereco endereco = viaCepService.consultarCep(dto.getCep());

        if (!enderecoRepository.existsById(endereco.getCep())) {
            enderecoRepository.save(endereco);
        }

        teacher.setEndereco(endereco);
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(String cpf) {
        Teacher teacher = teacherRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));

        if(teacher.getStudents() != null){
            teacher.getStudents().forEach(s -> s.setTeacher(null));
        }

        if (teacher.getClassStudant() != null) {
            teacher.getClassStudant().setTeacher(null);
        }

        if (teacher.getSchool() != null) {
            teacher.setSchool(null);
        }

        teacherRepository.delete(teacher);
    }

    @Override
    public Teacher findById(String cpf) {
        return teacherRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
    }

    @Override
    public Teacher create(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setCpf(teacherDTO.getCpf());
        teacher.setName(teacherDTO.getName());

        Endereco endereco = viaCepService.consultarCep(teacherDTO.getCep());

        if (!enderecoRepository.existsById(endereco.getCep())) {
            enderecoRepository.save(endereco);
        }

        teacher.setEndereco(endereco);
        return teacherRepository.save(teacher);
    }
}
