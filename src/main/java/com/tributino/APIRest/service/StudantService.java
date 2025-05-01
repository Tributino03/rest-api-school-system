package com.tributino.APIRest.service;

import com.tributino.APIRest.dto.StudantDTO;
import com.tributino.APIRest.model.ClassStudant;
import com.tributino.APIRest.model.School;
import com.tributino.APIRest.model.Studant;
import com.tributino.APIRest.model.Teacher;

public interface StudantService{

    ClassStudant findClassByStudantId(String ra);

    School findSchoolByStudantId(String ra);

    Teacher findTeacherByStudantId(String ra);

    void update(String ra, Studant studant);

    void delete(String ra);

    Studant findById(String ra);

    Studant create(StudantDTO studantDTO);
}
