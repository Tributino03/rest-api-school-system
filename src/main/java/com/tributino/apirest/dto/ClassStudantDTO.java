package com.tributino.apirest.dto;

import com.tributino.apirest.model.ClassStudant;
import com.tributino.apirest.model.Studant;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ClassStudantDTO {
    private Long id;
    private String grade;
    private String teacherCpf;
    private String schoolCodInep;

    public ClassStudantDTO(ClassStudant entity) {
        this.id = entity.getId();
        this.grade = entity.getGrade();

        if (entity.getTeacher() != null) {
            this.teacherCpf = entity.getTeacher().getCpf();
        }

        if (entity.getSchool() != null) {
            this.schoolCodInep = entity.getSchool().getCodInep();
        }
    }
}
