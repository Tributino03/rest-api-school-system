package com.tributino.apirest.dto;

import com.tributino.apirest.model.Studant;
import com.tributino.apirest.model.Teacher;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TeacherDTO {

    @Size(min = 11, max = 11, message = "O código INEP deve ter exatamente 11 dígitos.")
    private String cpf;

    @NotBlank(message = "O nome do professor é obrigatório.")
    private String name;

    @NotBlank(message = "O CEP é obrigatório.")
    private String cep;

    private Long id;

    public TeacherDTO(Teacher teacher) {
        this.id = teacher.getClassStudant().getId();
        this.name = teacher.getName();
    }
}
