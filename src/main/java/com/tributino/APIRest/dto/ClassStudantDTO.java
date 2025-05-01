package com.tributino.APIRest.dto;

import com.tributino.APIRest.model.School;
import com.tributino.APIRest.model.Teacher;
import lombok.Data;

@Data
public class ClassStudantDTO {
    private Long id;
    private String grade;
    private String teacherCpf;
    private String schoolCodInep;
}
