package com.tributino.apirest.repository;

import com.tributino.apirest.model.ClassStudant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassStudantRepository extends CrudRepository <ClassStudant, Long> {
}
