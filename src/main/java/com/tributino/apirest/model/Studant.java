package com.tributino.apirest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_studant")
public class Studant {

    @Id
    @Size(min = 7, max = 7, message = "O RA deve ter exatamente 7 dígitos.")
    @Pattern(regexp = "\\d{7}", message = "O RA deve conter apenas números.")
    private String ra;


    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "classStudant_id")
    private ClassStudant classStudant;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne
    private Endereco endereco;
}