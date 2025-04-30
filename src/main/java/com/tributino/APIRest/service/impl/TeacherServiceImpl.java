package com.tributino.APIRest.service.impl;

import com.tributino.APIRest.dto.TeacherDTO;
import com.tributino.APIRest.model.ClassStudant;
import com.tributino.APIRest.model.Teacher;
import com.tributino.APIRest.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public Iterable<ClassStudant> fetchAll() {
        return null;
    }

    @Override
    public void insert(ClassStudant classStudant) {

    }

    @Override
    public void update(Long id, ClassStudant classStudant) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Teacher findById(String cpf) {
        return null;
    }

    @Override
    public Teacher create(TeacherDTO teacherDTO) {
        return null;
    }
}
