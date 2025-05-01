package com.tributino.APIRest.service.impl;

import com.tributino.APIRest.dto.StudantDTO;
import com.tributino.APIRest.model.*;
import com.tributino.APIRest.repository.EnderecoRepository;
import com.tributino.APIRest.repository.StudantRepository;
import com.tributino.APIRest.service.StudantService;
import com.tributino.APIRest.service.ViaCepService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StudantServiceImpl implements StudantService {

    @Autowired
    private StudantRepository studantRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public ClassStudant findClassByStudantId(String ra) {
        Studant classStudant = studantRepository.findById(ra)
                .orElseThrow(() -> new EntityNotFoundException("O aluno nao existe"));
        return classStudant.getClassStudant();
    }

    @Override
    public School findSchoolByStudantId(String ra) {
        Studant school = studantRepository.findById(ra)
                .orElseThrow(() -> new EntityNotFoundException("O aluno nao existe"));
        return school.getSchool();
    }

    @Override
    public Teacher findTeacherByStudantId(String ra) {
        Studant teacher = studantRepository.findById(ra)
                .orElseThrow(() -> new EntityNotFoundException("O aluno nao existe"));
        return teacher.getTeacher();
    }

    @Override
    @Transactional
    public void update(String ra, Studant studant) {
        Studant existing = studantRepository.findById(ra)
                .orElseThrow(() -> new EntityNotFoundException("O aluno não existe"));

        existing.setClassStudant(studant.getClassStudant());
        existing.setTeacher(studant.getTeacher());

        if (studant.getEndereco() != null) {
            String novoCep   = studant.getEndereco().getCep();
            String cepAtual  = existing.getEndereco() != null
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
    public void delete(String ra) {
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
    public Studant findById(String ra) {
        Studant studant = studantRepository.findById(ra)
                .orElseThrow(() -> new EntityNotFoundException("O aluno nao existe"));
        return studant;
    }

    @Override
    public Studant create(StudantDTO studantDTO) {
        Studant studant = new Studant();
        studant.setRa(studant.getRa());
        studant.setName(studant.getName());

        Endereco endereco = viaCepService.consultarCep(studantDTO.getCep());

        if (!enderecoRepository.existsById(endereco.getCep())) {
            enderecoRepository.save(endereco);
        }

        studant.setEndereco(endereco);
        return studantRepository.save(studant);
    }
}
