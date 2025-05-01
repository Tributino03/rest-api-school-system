package com.tributino.APIRest.repository;

import com.tributino.APIRest.model.ClassStudant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassStudantRepository extends CrudRepository <ClassStudant, Long> {
}
