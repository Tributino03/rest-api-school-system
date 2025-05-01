package com.tributino.apirest.service;

import com.tributino.apirest.dto.ClassStudantDTO;
import com.tributino.apirest.dto.SchoolDTO;
import com.tributino.apirest.dto.StudantDTO;
import com.tributino.apirest.dto.TeacherDTO;
import com.tributino.apirest.model.ClassStudant;
import com.tributino.apirest.model.School;
import com.tributino.apirest.model.Studant;
import com.tributino.apirest.model.Teacher;

import java.util.List;

public interface SchoolService {

    List<StudantDTO> findStudantsBySchoolId(String codInep);

    List<TeacherDTO> findTeacherBySchoolId(String codInep);

    List<ClassStudantDTO> findClassBySchoolId(String codInep);

    SchoolDTO FindById(String codInep);

    SchoolDTO create(SchoolDTO schoolDTO);
}
