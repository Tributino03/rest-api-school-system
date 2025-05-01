package com.tributino.apirest.service;

import com.tributino.apirest.dto.ClassStudantDTO;
import com.tributino.apirest.dto.SchoolDTO;
import com.tributino.apirest.dto.StudantDTO;
import com.tributino.apirest.dto.TeacherDTO;
import com.tributino.apirest.model.ClassStudant;
import com.tributino.apirest.model.School;
import com.tributino.apirest.model.Studant;
import com.tributino.apirest.model.Teacher;

public interface StudantService{

    ClassStudantDTO findClassByStudantId(String ra);

    SchoolDTO findSchoolByStudantId(String ra);

    TeacherDTO findTeacherByStudantId(String ra);

    StudantDTO update(String ra, Studant studant);

    StudantDTO delete(String ra);

    StudantDTO findById(String ra);

    StudantDTO create(StudantDTO studantDTO);
}
