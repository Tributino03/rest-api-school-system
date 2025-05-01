package com.tributino.apirest.repository;

import com.tributino.apirest.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository <Teacher, String> {
}
