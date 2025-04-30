package com.tributino.APIRest.service.impl;

import com.tributino.APIRest.dto.SchoolDTO;
import com.tributino.APIRest.model.ClassStudant;
import com.tributino.APIRest.model.School;
import com.tributino.APIRest.service.SchoolService;

public class SchoolServiceImpl implements SchoolService {
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
    public School FindById(String codInep) {
        return null;
    }

    @Override
    public School create(SchoolDTO schoolDTO) {
        return null;
    }
}
