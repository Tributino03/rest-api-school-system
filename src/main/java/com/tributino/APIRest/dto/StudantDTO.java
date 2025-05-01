package com.tributino.APIRest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudantDTO {

    @Size(min = 7, max = 7, message = "O código INEP deve ter exatamente 7 dígitos.")
    @Pattern(regexp = "\\d{7}", message = "O código RA deve conter apenas números.")
    private String ra;

    @NotBlank(message = "O nome do aluno é obrigatorio")
    private String name;

    @NotBlank(message = "O CEP é obrigatório.")
    private String cep;
}
