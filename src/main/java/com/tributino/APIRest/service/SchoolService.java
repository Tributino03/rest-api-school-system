package com.tributino.APIRest.service;

import com.tributino.APIRest.dto.SchoolDTO;
import com.tributino.APIRest.model.ClassStudant;
import com.tributino.APIRest.model.School;

public interface SchoolService {

    Iterable<ClassStudant> fetchAll();

    void insert(ClassStudant classStudant);

    void update(Long id, ClassStudant classStudant);

    void delete(Long id);

    School FindById(String codInep);

    School create(SchoolDTO schoolDTO);
}
