package com.tributino.apirest.service.impl;

import com.tributino.apirest.dto.ClassStudantDTO;
import com.tributino.apirest.dto.SchoolDTO;
import com.tributino.apirest.dto.StudantDTO;
import com.tributino.apirest.dto.TeacherDTO;
import com.tributino.apirest.model.*;
import com.tributino.apirest.repository.EnderecoRepository;
import com.tributino.apirest.repository.StudantRepository;
import com.tributino.apirest.service.StudantService;
import com.tributino.apirest.service.ViaCepService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudantServiceImpl implements StudantService {

    @Autowired
    private StudantRepository studantRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public ClassStudantDTO findClassByStudantId(String ra) {
        Studant studant = studantRepository.findById(ra)
                .orElseThrow(() -> new EntityNotFoundException("O aluno nao existe"));
        return new ClassStudantDTO(studant.getClassStudant());
    }

    @Override
    public SchoolDTO findSchoolByStudantId(String ra) {
        Studant studant = studantRepository.findById(ra)
                .orElseThrow(() -> new EntityNotFoundException("O aluno nao existe"));
        return new SchoolDTO(studant.getSchool());  // Retornando DTO
    }

    @Override
    public TeacherDTO findTeacherByStudantId(String ra) {
        Studant studant = studantRepository.findById(ra)
                .orElseThrow(() -> new EntityNotFoundException("O aluno nao existe"));
        return new TeacherDTO(studant.getTeacher());  // Retornando DTO
    }

    @Override
    @Transactional
    public StudantDTO update(String ra, Studant studant) {
        Studant existing = studantRepository.findById(ra)
                .orElseThrow(() -> new EntityNotFoundException("O aluno não existe"));

        existing.setClassStudant(studant.getClassStudant());
        existing.setTeacher(studant.getTeacher());

        if (studant.getEndereco() != null) {
            String novoCep = studant.getEndereco().getCep();
            String cepAtual = existing.getEndereco() != null
                    ? existing.getEndereco().getCep()
                    : null;

            if (novoCep != null && !novoCep.equals(cepAtual)) {
                Endereco endereco = viaCepService.consultarCep(novoCep);

                if (!enderecoRepository.existsById(endereco.getCep())) {
                    enderecoRepository.save(endereco);
                }

                existing.setEndereco(endereco);
            }
        }

        studantRepository.save(existing);
    }

    @Override
    public StudantDTO delete(String ra) {
        Studant studant = studantRepository.findById(ra)
                .orElseThrow(() -> new EntityNotFoundException("O aluno nao existe"));

        if (studant.getClassStudant() != null) {
            studant.getClassStudant().setStudantsClass(null);
        }

        if (studant.getTeacher() != null) {
            studant.getTeacher().setClassStudant(null);
        }

        if (studant.getSchool() != null) {
            studant.getSchool().setStudantsSchool(null);
        }

        studantRepository.delete(studant);
    }

    @Override
    public StudantDTO findById(String ra) {
        Studant studant = studantRepository.findById(ra)
                .orElseThrow(() -> new EntityNotFoundException("O aluno nao existe"));
        return new StudantDTO(studant);
    }

    @Override
    public StudantDTO create(StudantDTO studantDTO) {
        Studant studant = new Studant();
        studant.setRa(studantDTO.getRa());
        studant.setName(studantDTO.getName());

        Endereco endereco = viaCepService.consultarCep(studantDTO.getCep());

        if (!enderecoRepository.existsById(endereco.getCep())) {
            enderecoRepository.save(endereco);
        }

        studant.setEndereco(endereco);
        studant = studantRepository.save(studant);
        return new StudantDTO(studant);
    }
}
