package com.tributino.apirest.repository;

import com.tributino.apirest.model.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository <School, String> {
}
