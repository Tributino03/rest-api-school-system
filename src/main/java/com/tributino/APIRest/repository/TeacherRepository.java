package com.tributino.APIRest.repository;

import com.tributino.APIRest.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository <Teacher, String> {
}
