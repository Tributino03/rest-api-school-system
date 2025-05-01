package com.tributino.APIRest.service;

import com.tributino.APIRest.dto.TeacherDTO;
import com.tributino.APIRest.model.ClassStudant;
import com.tributino.APIRest.model.School;
import com.tributino.APIRest.model.Studant;
import com.tributino.APIRest.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Studant> findStudantsByTeacherId(String cpf);

    ClassStudant findClassByTeacherId(String cpf);

    School findSchoolByTeacherId(String cpf);

    void update(String cpf, TeacherDTO dto);

    void delete(String cpf);

    Teacher findById(String cpf);

    Teacher create(TeacherDTO teacherDTO);
}
