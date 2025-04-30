package com.tributino.APIRest.service.impl;

import com.tributino.APIRest.dto.StudantDTO;
import com.tributino.APIRest.model.ClassStudant;
import com.tributino.APIRest.model.Studant;
import com.tributino.APIRest.service.StudantService;

public class StudantServiceImpl implements StudantService {
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
    public Studant findById(String ra) {
        return null;
    }

    @Override
    public Studant create(StudantDTO studantDTO) {
        return null;
    }
}
