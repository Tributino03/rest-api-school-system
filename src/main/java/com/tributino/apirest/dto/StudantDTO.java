package com.tributino.apirest.dto;

import com.tributino.apirest.model.ClassStudant;
import com.tributino.apirest.model.Studant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StudantDTO {

    @Size(min = 7, max = 7, message = "O código INEP deve ter exatamente 7 dígitos.")
    @Pattern(regexp = "\\d{7}", message = "O código RA deve conter apenas números.")
    private String ra;

    @NotBlank(message = "O nome do aluno é obrigatorio")
    private String name;

    @NotBlank(message = "O CEP é obrigatório.")
    private String cep;

    private Long id;

    public StudantDTO(Studant studant) {
        this.id = studant.getClassStudant().getId();
        this.name = studant.getName();
    }
}
