package com.tributino.apirest.service.impl;

import com.tributino.apirest.dto.StudantDTO;
import com.tributino.apirest.dto.TeacherDTO;
import com.tributino.apirest.model.*;
import com.tributino.apirest.repository.EnderecoRepository;
import com.tributino.apirest.repository.TeacherRepository;
import com.tributino.apirest.service.TeacherService;
import com.tributino.apirest.service.ViaCepService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public List<StudantDTO> findStudantsByTeacherId(String cpf) {
        Teacher teacher = teacherRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
        return teacher.getStudents().stream()
                .map(StudantDTO::new)
                .collect(Collectors.toList());
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
    public TeacherDTO update(String cpf, TeacherDTO dto) {
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
    public TeacherDTO delete(String cpf) {
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
    public TeacherDTO findById(String cpf) {
        Teacher teacher = teacherRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
        return new TeacherDTO(teacher);  // Convertendo para DTO
    }

    @Override
    public TeacherDTO create(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setCpf(teacherDTO.getCpf());
        teacher.setName(teacherDTO.getName());

        Endereco endereco = viaCepService.consultarCep(teacherDTO.getCep());

        if (!enderecoRepository.existsById(endereco.getCep())) {
            enderecoRepository.save(endereco);
        }

        teacher.setEndereco(endereco);
        teacher = teacherRepository.save(teacher);
        return new TeacherDTO(teacher);
    }
}
