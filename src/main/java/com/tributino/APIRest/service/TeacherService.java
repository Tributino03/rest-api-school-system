package com.tributino.APIRest.service;

import com.tributino.APIRest.dto.TeacherDTO;
import com.tributino.APIRest.model.ClassStudant;
import com.tributino.APIRest.model.Teacher;

public interface TeacherService {
    Iterable<ClassStudant> fetchAll();

    void insert(ClassStudant classStudant);

    void update(Long id, ClassStudant classStudant);

    void delete(Long id);

    Teacher findById(String cpf);

    Teacher create(TeacherDTO teacherDTO);
}
