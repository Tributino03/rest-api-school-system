package com.tributino.APIRest.service;

import com.tributino.APIRest.dto.SchoolDTO;
import com.tributino.APIRest.model.ClassStudant;
import com.tributino.APIRest.model.School;
import com.tributino.APIRest.model.Studant;
import com.tributino.APIRest.model.Teacher;

import java.util.List;

public interface SchoolService {

    List<Studant> findStudantsBySchoolId(String codInep);

    List<Teacher> findTeacherBySchoolId(String codInep);

    List<ClassStudant> findClassBySchoolId(String codInep);

    void delete(String codInep);

    School FindById(String codInep);

    School create(SchoolDTO schoolDTO);
}
