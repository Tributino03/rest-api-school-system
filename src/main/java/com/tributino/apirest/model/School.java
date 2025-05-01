package com.tributino.apirest.model;

import jakarta.persistence.*;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_school")
public class School {

    @Id
    @Size(min = 8, max = 8, message = "O código INEP deve ter exatamente 8 dígitos.")
    @Pattern(regexp = "\\d{8}", message = "O código INEP deve conter apenas números.")
    private String codInep;


    @NotBlank
    private String name;

    @OneToMany(mappedBy = "school")
    private List<Studant> studantsSchool;

    @OneToMany(mappedBy = "school")
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "school")
    private List<ClassStudant> classStudants;

    @OneToOne
    private Endereco endereco;

}
