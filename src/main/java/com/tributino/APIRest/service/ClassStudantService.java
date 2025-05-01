package com.tributino.APIRest.service;

import com.tributino.APIRest.dto.ClassStudantDTO;
import com.tributino.APIRest.model.ClassStudant;
import com.tributino.APIRest.model.Studant;
import com.tributino.APIRest.model.Teacher;

import java.util.List;

public interface ClassStudantService {

    List<Studant> findStudantsByClassId(Long id);

    Teacher findTeacherByClassId(Long id);

    void update(Long id, ClassStudant classStudant);

    ClassStudant findById(Long id);

    ClassStudant create(ClassStudantDTO classStudantDTO);
}
