package com.tributino.APIRest.repository;

import com.tributino.APIRest.model.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository <School, String> {
}
