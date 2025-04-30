package com.tributino.APIRest.service;

import com.tributino.APIRest.dto.ClassStudantDTO;
import com.tributino.APIRest.model.ClassStudant;

public interface ClassStudantService {

    Iterable<ClassStudant> fetchAll();

    void insert(ClassStudant classStudant);

    void update(Long id, ClassStudant classStudant);

    void delete(Long id);

    ClassStudant findById(Long id);

    ClassStudant create(ClassStudantDTO classStudantDTO);
}
