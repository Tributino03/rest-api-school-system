package com.tributino.apirest.service;

import com.tributino.apirest.dto.ClassStudantDTO;
import com.tributino.apirest.dto.StudantDTO;
import com.tributino.apirest.dto.TeacherDTO;

import java.util.List;

public interface ClassStudantService {

    List<StudantDTO> findStudantsByClassId(Long id);

    TeacherDTO findTeacherByClassId(Long id);

    ClassStudantDTO update(Long id, ClassStudantDTO dto);

    ClassStudantDTO findById(Long id);

    ClassStudantDTO create(ClassStudantDTO dto);
}
