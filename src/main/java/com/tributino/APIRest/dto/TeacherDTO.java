package com.tributino.APIRest.dto;

import com.tributino.APIRest.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TeacherDTO {

    @Size(min = 11, max = 11, message = "O código INEP deve ter exatamente 11 dígitos.")
    private String cpf;

    @NotBlank(message = "O nome do professor é obrigatório.")
    private String name;

    @NotBlank(message = "O CEP é obrigatório.")
    private String cep;
}
