package com.tributino.APIRest.repository;

import com.tributino.APIRest.model.Studant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudantRepository extends CrudRepository <Studant, String> {
}
