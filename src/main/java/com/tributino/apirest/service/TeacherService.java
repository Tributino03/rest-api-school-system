package com.tributino.apirest.service;

import com.tributino.apirest.dto.StudantDTO;
import com.tributino.apirest.dto.TeacherDTO;
import com.tributino.apirest.model.ClassStudant;
import com.tributino.apirest.model.School;
import com.tributino.apirest.model.Studant;
import com.tributino.apirest.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<StudantDTO> findStudantsByTeacherId(String cpf);

    ClassStudant findClassByTeacherId(String cpf);

    School findSchoolByTeacherId(String cpf);

    TeacherDTO update(String cpf, TeacherDTO dto);

    TeacherDTO delete(String cpf);

    TeacherDTO findById(String cpf);

    TeacherDTO create(TeacherDTO teacherDTO);
}
