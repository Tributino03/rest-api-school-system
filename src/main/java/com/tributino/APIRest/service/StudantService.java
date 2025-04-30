package com.tributino.APIRest.service;

import com.tributino.APIRest.dto.StudantDTO;
import com.tributino.APIRest.model.ClassStudant;
import com.tributino.APIRest.model.Studant;

public interface StudantService {
    Iterable<ClassStudant> fetchAll();

    void insert(ClassStudant classStudant);

    void update(Long id, ClassStudant classStudant);

    void delete(Long id);

    Studant findById(String ra);

    Studant create(StudantDTO studantDTO);
}
