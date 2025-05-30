package com.tributino.apirest.dto;

import com.tributino.apirest.model.School;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SchoolDTO {

    @Size(min = 8, max = 8, message = "O código INEP deve ter exatamente 8 dígitos.")
    @Pattern(regexp = "\\d{8}", message = "O código INEP deve conter apenas números.")
    private String codInep;

    @NotBlank(message = "O nome da escola é obrigatório.")
    private String name;

    @NotBlank(message = "O CEP é obrigatório.")
    private String cep;

    public SchoolDTO(School save) {
    }
}
