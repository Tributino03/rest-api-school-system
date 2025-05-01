package com.tributino.apirest.repository;

import com.tributino.apirest.model.Studant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudantRepository extends CrudRepository <Studant, String> {
}
